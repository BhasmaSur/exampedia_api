package com.exampedia.exampedia_api.projections;

import javax.validation.constraints.NotNull;

public class ProjectedUser {
	
	private int userid;
	private String userName;
	private String email;
	private String preferenceCourses;
	private String preferenceSubjects;
	private String preferenceExams;
	private String picUrl;
	private String picId;
	private String roles;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public ProjectedUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectedUser(int userid, String userName, String email, String preferenceCourses, String preferenceSubjects,
			String preferenceExams, String picUrl, String picId, String roles) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.email = email;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picUrl = picUrl;
		this.picId = picId;
		this.roles = roles;
	}
	
}
