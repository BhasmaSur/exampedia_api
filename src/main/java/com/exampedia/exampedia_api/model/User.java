package com.exampedia.exampedia_api.model;

import java.util.Arrays;

import javax.persistence.Column;
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
	@Column(name = "picByte", length = 1000)
	private byte[] picByte;
	@NotNull
	private String picType;
	@NotNull
	private String roles;
	@NotNull
	private boolean active;
	@NotNull
	private String age;
	@NotNull
	private String mobile;
	@NotNull
	private String address;
	@NotNull
	private String biodata;
	@NotNull
	private String proffession;
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
	public boolean getActive() {
		return active;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	
	public User(int userid, @NotNull String userName, @NotNull String email, @NotNull String password,
			@NotNull String dob, @NotNull String preferenceCourses, @NotNull String preferenceSubjects,
			@NotNull String preferenceExams, @NotNull byte[] picByte, @NotNull String picType, @NotNull String roles,
			@NotNull boolean active, @NotNull String age, @NotNull String mobile, @NotNull String address,
			@NotNull String biodata, @NotNull String proffession) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picByte = picByte;
		this.picType = picType;
		this.roles = roles;
		this.active = active;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.biodata = biodata;
		this.proffession = proffession;
	}
	public User(@NotNull String userName, @NotNull String email, @NotNull String password,
			@NotNull String dob, @NotNull String preferenceCourses, @NotNull String preferenceSubjects,
			@NotNull String preferenceExams, @NotNull byte[] picByte, @NotNull String picType, @NotNull String roles,
			@NotNull boolean active, @NotNull String age, @NotNull String mobile, @NotNull String address,
			@NotNull String biodata, @NotNull String proffession) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.preferenceCourses = preferenceCourses;
		this.preferenceSubjects = preferenceSubjects;
		this.preferenceExams = preferenceExams;
		this.picType = picType;
		this.picByte = picByte;
		this.roles = roles;
		this.active = active;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.biodata = biodata;
		this.proffession = proffession;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", dob=" + dob + ", preferenceCourses=" + preferenceCourses + ", preferenceSubjects="
				+ preferenceSubjects + ", preferenceExams=" + preferenceExams + ", picByte=" + Arrays.toString(picByte)
				+ ", picType=" + picType + ", roles=" + roles + ", active=" + active + ", age=" + age + ", mobile="
				+ mobile + ", address=" + address + ", biodata=" + biodata + ", proffession=" + proffession + "]";
	}
	
	
}
