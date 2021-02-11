package com.exampedia.exampedia_api.projections;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.exampedia.exampedia_api.model.Course;

public class ProjectedUser {
	
	private int userid;
	private String userName;
	private String email;
	private String preferenceCourses;
	private String preferenceSubjects;
	private String preferenceExams;
	private byte[] picByte;
	private String picType;
	private String roles;
	private boolean active;
	private String age;
	private String dob;
	private String mobile;
	private String address;
	private String biodata;
	private String proffession;
	private List<Course> coursesSubscribed;
	
	
	public List<Course> getCoursesSubscribed() {
		return coursesSubscribed;
	}
	public void setCoursesSubscribed(List<Course> coursesSubscribed) {
		this.coursesSubscribed = coursesSubscribed;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
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

	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	public String getPicType() {
		return picType;
	}
	public void setPicType(String picType) {
		this.picType = picType;
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
			String preferenceExams, byte[] picByte, String picType, String roles, boolean active, String age, String dob,
			String mobile, String address, String biodata, String proffession, List<Course> coursesSubscribed) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.email = email;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picType = picType;
		this.picType = picType;
		this.roles = roles;
		this.active = active;
		this.age = age;
		this.dob = dob;
		this.mobile = mobile;
		this.address = address;
		this.biodata = biodata;
		this.proffession = proffession;
		this.coursesSubscribed = coursesSubscribed;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBiodata() {
		return biodata;
	}
	public void setBiodata(String biodata) {
		this.biodata = biodata;
	}
	public String getProffession() {
		return proffession;
	}
	public void setProffession(String proffession) {
		this.proffession = proffession;
	}

	
}
