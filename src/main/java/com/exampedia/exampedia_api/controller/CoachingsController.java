package com.exampedia.exampedia_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampedia.exampedia_api.model.AllCoachingResponse;
import com.exampedia.exampedia_api.model.AuthenticationRequest;
import com.exampedia.exampedia_api.model.AuthenticationResponse;
import com.exampedia.exampedia_api.model.Coaching;
import com.exampedia.exampedia_api.model.CoachingSignUpRequest;
import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.ErrorResponse;
import com.exampedia.exampedia_api.model.Exam;
import com.exampedia.exampedia_api.model.ExamUpdateRequest;
import com.exampedia.exampedia_api.model.PdfUpdateRequest;
import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.model.VideoUpdateRequest;
import com.exampedia.exampedia_api.projections.ProjectedCoaching;
import com.exampedia.exampedia_api.projections.ProjectedCoachingAdmin;
import com.exampedia.exampedia_api.projections.ProjectedUser;
import com.exampedia.exampedia_api.services.CoachingsDetailService;
import com.exampedia.exampedia_api.services.MyUserDetailService;
import com.exampedia.exampedia_api.util.JWTUtil;

@RestController
public class CoachingsController {

	@Autowired
	MyUserDetailService userDetailsService;
	
	@Autowired
	JWTUtil jwtTokenUtil;
	
	@Autowired
	CoachingsDetailService coachingsDetailService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	/*
	@GetMapping("/")
	public String getWelcomePage() {
		return "Hello User";
	}*/
	@GetMapping("/coachings")
	public ResponseEntity<?> getALLCoachings() throws Exception{
		List<ProjectedCoaching> coachings =coachingsDetailService.getAllCoachings();
		return ResponseEntity.ok(coachings);
	}
	@GetMapping("/coachings/{coachingId}")
	public ResponseEntity<?> getCoaching(@PathVariable("coachingId") String coachingId) throws Exception{
		ProjectedCoaching coaching = coachingsDetailService.getCoachingById(Integer.parseInt(coachingId));
		return ResponseEntity.ok(coaching);
	}
	@GetMapping("/coaching-admin")
	public ResponseEntity<?> getCoachingAuthenticated(@RequestHeader("Authorization") String authorizationHeader) throws Exception{
		String username = null;
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		ProjectedCoachingAdmin adminLoggedIn = coachingsDetailService.findByCoachingEmail(username);
		//Coaching coachingObject=adminLoggedIn;
		return ResponseEntity.ok(adminLoggedIn);
	}
	@PostMapping("/coaching-signup")
	public ResponseEntity<?> signUpCoaching(@RequestBody CoachingSignUpRequest coachingData)throws Exception{
		boolean boolCheckForDublicate= userDetailsService.checkForDublicateEmail(coachingData.getEmail());
		ErrorResponse errorResponse = new ErrorResponse();
		if(boolCheckForDublicate) {  //if true , user is present
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("Coaching is already present, change your email id");
		}
		else { //user is not present
			boolean boolUserAdded=userDetailsService.addUserIntoDataBase(coachingData.getEmail(),coachingData.getName(),coachingData.getPassword());
			if(boolUserAdded) {
				boolean boolCoachingAdded=coachingsDetailService.addCoachingIntoDatabase(coachingData);
				if(boolCoachingAdded) {
					errorResponse.setErrorCode(200);
					errorResponse.setErrorMessage("Coaching is signedup Successfully");
				}
				else {
					errorResponse.setErrorCode(422);
					errorResponse.setErrorMessage("Coaching signup failed");
				}
			}
			else {
				errorResponse.setErrorCode(422);
				errorResponse.setErrorMessage("User signup failed");
			}
		}
		return ResponseEntity.ok(errorResponse);
	}
	@PutMapping("/coaching-update")
	public ResponseEntity<?> updateCoachingDetails(@RequestBody Coaching coachingData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Coaching coachingInToken=coachingsDetailService.getCoachingByEmail(username);
		coachingData.setCoachingid(coachingInToken.getCoachingid());
		coachingData.setCoachingEmail(coachingInToken.getCoachingEmail());
		coachingData.setCoachingPassword(coachingInToken.getCoachingPassword());
		coachingData.setCoachingStatus(coachingInToken.getCoachingStatus());
		coachingData.setCoachingStars(coachingInToken.getCoachingStars());
		coachingData.setCoachingCourses(coachingInToken.getCoachingCourses());
		Optional<Coaching> coachingReturned=coachingsDetailService.updateCoachingDetails(coachingData);
		if(coachingReturned.isEmpty()) {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("User data not updated");
			return ResponseEntity.ok(errorResponse);
		}
		else {
			return ResponseEntity.ok(coachingReturned);
		}
	}
	
	@PutMapping("/course-update")
	public ResponseEntity<?> updateCourseDetails(@RequestBody Course courseData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Coaching coachingInToken=coachingsDetailService.getCoachingByEmail(username);
		int courseBelongToCoachingId=coachingsDetailService.getCoachingIdForCourse(courseData.getCourseId());
		if(coachingInToken.getCoachingid()==courseBelongToCoachingId) {
			Optional<Course> courseUpdated=coachingsDetailService.updateCourseDetails(courseData);
			return ResponseEntity.ok(courseUpdated);
		}
		else {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("this coaching doesnt have access to the course its trying to modify");
			return ResponseEntity.ok(errorResponse);
		}
	
	}
	
	@PutMapping("/exam-update")
	public ResponseEntity<?> updateExamDetails(@RequestBody ExamUpdateRequest examData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Coaching coachingInToken=coachingsDetailService.getCoachingByEmail(username);
		int courseBelongToCoachingId=coachingsDetailService.getCoachingIdForCourse(examData.getExamCourseId());
		if(coachingInToken.getCoachingid()==courseBelongToCoachingId) {
			Optional<Course> courseUpdated=coachingsDetailService.updateExamDetails(examData);
			return ResponseEntity.ok(courseUpdated);
		}
		else {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("this coaching doesnt have access to the course its trying to modify");
			return ResponseEntity.ok(errorResponse);
		}
	}
	@PutMapping("/video-update")
	public ResponseEntity<?> updateVideoDetails(@RequestBody VideoUpdateRequest videoData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Coaching coachingInToken=coachingsDetailService.getCoachingByEmail(username);
		int courseBelongToCoachingId=coachingsDetailService.getCoachingIdForCourse(videoData.getVideoCourseId());
		if(coachingInToken.getCoachingid()==courseBelongToCoachingId) {
			Optional<Course> courseUpdated=coachingsDetailService.updateVideoDetails(videoData);
			return ResponseEntity.ok(courseUpdated);
		}
		else {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("this coaching doesnt have access to the course its trying to modify");
			return ResponseEntity.ok(errorResponse);
		}
	}
	@PutMapping("/pdf-update")
	public ResponseEntity<?> updatePdfDetails(@RequestBody PdfUpdateRequest pdfData,@RequestHeader("Authorization") String authorizationHeader)throws Exception{
		String username = null;
		ErrorResponse errorResponse = new ErrorResponse();
		String jwt = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt=authorizationHeader.substring(7);
			username=jwtTokenUtil.extractUsername(jwt);
		}
		Coaching coachingInToken=coachingsDetailService.getCoachingByEmail(username);
		int courseBelongToCoachingId=coachingsDetailService.getCoachingIdForCourse(pdfData.getPdfCourseId());
		if(coachingInToken.getCoachingid()==courseBelongToCoachingId) {
			Optional<Course> courseUpdated=coachingsDetailService.updatePdfDetails(pdfData);
			return ResponseEntity.ok(courseUpdated);
		}
		else {
			errorResponse.setErrorCode(422);
			errorResponse.setErrorMessage("this coaching doesnt have access to the course its trying to modify");
			return ResponseEntity.ok(errorResponse);
		}
	}

	
	
	
}



/*
 * {
    "coachingId":2,
    "coachingName":"pappu gadariya",
    "coachingemail":"pappu@gmail.com",
    "coachingpassword":"NaN",
    "coachingStatus":1,
    "coachingMobile":"8888888888",
    "coachingOwner":"rama kant",
    "coachingPicUrl":"somthing.png",
    "coachingPicId":"INADS34",
    "coachingStars":"0/5"
}
 */
