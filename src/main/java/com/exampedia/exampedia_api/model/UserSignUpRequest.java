package com.exampedia.exampedia_api.model;

public class UserSignUpRequest {

	private String name;
	private String email;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserSignUpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSignUpRequest(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
}
