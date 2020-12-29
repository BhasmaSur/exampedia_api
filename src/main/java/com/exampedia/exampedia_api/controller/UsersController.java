package com.exampedia.exampedia_api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.exampedia.exampedia_api.data_provider.CreateDummyUsers;
import com.exampedia.exampedia_api.model.AuthenticationRequest;
import com.exampedia.exampedia_api.model.AuthenticationResponse;
import com.exampedia.exampedia_api.model.ErrorResponse;
import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.projections.ProjectedUser;
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
			boolean boolUserAdded=userDetailsService.addUserIntoDataBase(userData.getEmail(),userData.getName(),userData.getPassword());
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
		Optional<User> userReturned = userDetailsService.updateUser(userData);
		if(userReturned.isEmpty()) {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("User data not updated");
			return ResponseEntity.ok(errorResponse);
		}
		else {
			return ResponseEntity.ok(userReturned);
		}
	
	}
	
	
	//======================= helping functions ============================================================
	private ProjectedUser trimDataAccordingToProjectedUser(User userObject){
		ProjectedUser projectedUser=new ProjectedUser();
		projectedUser.setUserid(userObject.getId());
		projectedUser.setUserName(userObject.getUserName());
		projectedUser.setEmail(userObject.getEmail());
		projectedUser.setPicId(userObject.getPicId());
		projectedUser.setPicUrl(userObject.getPicUrl());
		projectedUser.setPreferenceCourses(userObject.getPreferenceCourses());
		projectedUser.setPreferenceExams(userObject.getPreferenceExams());
		projectedUser.setPreferenceSubjects(userObject.getPreferenceSubjects());
		projectedUser.setRoles(userObject.getRoles());
		return projectedUser;
		
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
