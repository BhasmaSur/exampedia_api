package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	@NotNull
	private String userName;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String dob;
	@NotNull
	private String preferenceCourses;
	@NotNull
	private String preferenceSubjects;
	@NotNull
	private String preferenceExams;
	@NotNull
	private String picUrl;
	@NotNull
	private String picId;
	@NotNull
	private String roles;
	@NotNull
	private boolean active;
	public int getId() {
		return userid;
	}
	public void setId(int id) {
		this.userid = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPreferenceCourses() {
		return preferenceCourses;
	}
	public void setPreferenceCourses(String preferenceCourses) {
		this.preferenceCourses = preferenceCourses;
	}
	public String getPreferenceSubjects() {
		return preferenceSubjects;
	}
	public void setPreferenceSubjects(String preferenceSubjects) {
		this.preferenceSubjects = preferenceSubjects;
	}
	public String getPreferenceExams() {
		return preferenceExams;
	}
	public void setPreferenceExams(String preferenceExams) {
		this.preferenceExams = preferenceExams;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPicId() {
		return picId;
	}
	public void setPicId(String picId) {
		this.picId = picId;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public User(int id, String userName, String email, String password, String dob, String preferenceCourses,
			String preferenceSubjects, String preferenceExams, String picUrl, String picId, String roles,
			boolean active) {
		super();
		this.userid = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picUrl = picUrl;
		this.picId = picId;
		this.roles = roles;
		this.active = active;
	}
	public User(String userName, String email, String password, String dob, String preferenceCourses,
			String preferenceSubjects, String preferenceExams, String picUrl, String picId, String roles,
			boolean active) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picUrl = picUrl;
		this.picId = picId;
		this.roles = roles;
		this.active = active;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
