package com.exampedia.exampedia_api.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exampedia.exampedia_api.data_provider.CreateDummyUsers;
import com.exampedia.exampedia_api.model.AuthenticationRequest;
import com.exampedia.exampedia_api.model.AuthenticationResponse;
import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.ErrorResponse;
import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserCourseMap;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.projections.ProjectedImage;
import com.exampedia.exampedia_api.projections.ProjectedUser;
import com.exampedia.exampedia_api.repository.UserCourseMapRepository;
import com.exampedia.exampedia_api.repository.UserRepository;
import com.exampedia.exampedia_api.services.MyUserDetailService;
import com.exampedia.exampedia_api.util.JWTUtil;

@RestController
public class UsersController {



	@Autowired
	UserRepository userRepository;

	@Autowired
	JWTUtil jwtTokenUtil;

	@Autowired
	MyUserDetailService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
					);
		}
		catch(BadCredentialsException ex) {
			throw new Exception("Incorrect username or password", ex);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));

	}

	@GetMapping("/user")
	public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Optional<User> userLoggedIn = userRepository.findByEmail(username);
		User userObject=userLoggedIn.get();
		ProjectedUser projectedUser = trimDataAccordingToProjectedUser(userObject);
		List<UserCourseMap> userCourseMap=userDetailsService.getCoursesSubscribedByUser(userObject.getUserid());
		List<Course> coursesSubscribedByUser=userDetailsService.getCourseDetailSubscibedByUser(userCourseMap);
		projectedUser.setCoursesSubscribed(coursesSubscribedByUser);
		return ResponseEntity.ok(projectedUser);
	}

	@PostMapping("/user-signup")
	public ResponseEntity<?> signUpUser(@RequestBody UserSignUpRequest userData)throws Exception{
		boolean boolCheckForDublicate= userDetailsService.checkForDublicateEmail(userData.getEmail());
		ErrorResponse errorResponse = new ErrorResponse();
		if(boolCheckForDublicate) {  //if true , user is present
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("User is already present, change your email id");
		}
		else { //user is not present
			boolean boolUserAdded=userDetailsService.addUserIntoDataBase(userData.getEmail(),userData.getName(),userData.getPassword(),"USER");
			if(boolUserAdded) {
				errorResponse.setErrorCode(200);
				errorResponse.setErrorMessage("User is added successfully");
			}
		}
		return ResponseEntity.ok(errorResponse);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User userData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Optional<User> userLoggedIn = userRepository.findByEmail(username);
		User userObj=userLoggedIn.get();
		userData.setId(userObj.getId());
		userData.setPassword(userObj.getPassword());
		userData.setEmail(userObj.getEmail());
		userData.setRoles(userObj.getRoles());
		System.out.println("=====================spot 1=============== "+userData.toString());
		Optional<User> userReturned = userDetailsService.updateUser(userData);
		System.out.println("=====================spot 2=============== "+userReturned.toString());
		if(!userReturned.isPresent()) {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("User data not updated");
			return ResponseEntity.ok(errorResponse);
		}
		else {
			System.out.println("=====================spot 3=============== "+userReturned.toString());
			ProjectedUser projectedUser = trimDataAccordingToProjectedUser(userReturned.get());
			System.out.println("=====================spot 4=============== "+projectedUser.toString());
			List<UserCourseMap> userCourseMap=userDetailsService.getCoursesSubscribedByUser(userReturned.get().getUserid());
			List<Course> coursesSubscribedByUser=userDetailsService.getCourseDetailSubscibedByUser(userCourseMap);
			projectedUser.setCoursesSubscribed(coursesSubscribedByUser);
			return ResponseEntity.ok(projectedUser);
		}

	}
	@PostMapping("/upload-user-dp")
	public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file,@RequestHeader("Authorization") String authorizationHeader) throws IOException {
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Optional<User> userLoggedIn = userRepository.findByEmail(username);
//		userLoggedIn.get().setPicByte(compressBytes(file.getBytes()));
		userLoggedIn.get().setPicByte(file.getBytes());
		userLoggedIn.get().setPicType(file.getContentType());
		Optional<User> userReturned=userDetailsService.updateUser(userLoggedIn.get());
		if(userReturned.isPresent()) {
//			ProjectedImage imageStored=new ProjectedImage(decompressBytes(userReturned.get().getPicByte()),userReturned.get().getPicType());
			ProjectedImage imageStored=new ProjectedImage(userReturned.get().getPicByte(),userReturned.get().getPicType());

			return ResponseEntity.ok(imageStored);
		}
		errorResponse.setErrorCode(404);
		errorResponse.setErrorMessage("Failed");
		return ResponseEntity.ok(errorResponse);
		
	}

	//======================= helping functions ============================================================
	private ProjectedUser trimDataAccordingToProjectedUser(User userObject){
		ProjectedUser projectedUser=new ProjectedUser();
		projectedUser.setUserid(userObject.getId());
		projectedUser.setUserName(userObject.getUserName());
		projectedUser.setEmail(userObject.getEmail());
		projectedUser.setPicType(userObject.getPicType());
		projectedUser.setPicByte(userObject.getPicByte());
		projectedUser.setPreferenceCourses(userObject.getPreferenceCourses());
		projectedUser.setPreferenceExams(userObject.getPreferenceExams());
		projectedUser.setPreferenceSubjects(userObject.getPreferenceSubjects());
		projectedUser.setRoles(userObject.getRoles());
		projectedUser.setActive(userObject.getActive());
		projectedUser.setAddress(userObject.getAddress());
		projectedUser.setAge(userObject.getAge());
		projectedUser.setMobile(userObject.getMobile());
		projectedUser.setProffession(userObject.getProffession());
		projectedUser.setBiodata(userObject.getBiodata());
		projectedUser.setDob(userObject.getDob());
		return projectedUser;

	}
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}

/*
{
    "userid":1,
    "userName":"pappu gadariya",
    "email":"kappu@gmail.com",
    "password":"NaN",
    "dob":"12/06/20",
    "preferenceCourses":"MBBS,BCS",
    "preferenceSubjects":"MATHS,PHYSICS",
    "preferenceExams":"NDA",
    "picUrl":"somthing.png",
    "picId":"INADS34",
    "roles":"USER",
    "active":1
}
 */
