package com.exampedia.exampedia_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampedia.exampedia_api.model.AuthenticationRequest;
import com.exampedia.exampedia_api.model.AuthenticationResponse;
import com.exampedia.exampedia_api.services.MyUserDetailService;
import com.exampedia.exampedia_api.util.JWTUtil;

@RestController
public class Coachings {
	@Autowired
	JWTUtil jwtTokenUtil;
	
	@Autowired
	MyUserDetailService userDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String getALLCoachings() {
		return "Hello world";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			System.out.println("============================================================");
			System.out.println(authenticationRequest.getUsername());
			System.out.println("============================================================");
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
}
