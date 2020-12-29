package com.exampedia.exampedia_api.model;

import javax.validation.constraints.NotNull;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="coachings_table")
public class Coaching {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int coachingId;
	@NotNull
	private String coachingName;
	@NotNull
	private String coachingEmail;
	@NotNull
	private String coachingPassword;
	@NotNull
	private int coachingStatus;
	@NotNull
	private String coachingMobile;
	@NotNull
	private String coachingAddress;
	@NotNull
	private String coachingOwner;
	@NotNull
	private String coachingPicUrl;
	@NotNull
	private String coachingPicId;
	@NotNull
	private String coachingStars;
	
	@OneToMany(targetEntity=Course.class,cascade=CascadeType.ALL)
	@JoinColumn(name="courseCoachingId",referencedColumnName="CoachingId")
	private List<Course> coachingCourses;
	
	public int getCoachingid() {
		return coachingId;
	}
	public void setCoachingid(int coachingid) {
		this.coachingId = coachingid;
	}
	public String getCoachingName() {
		return coachingName;
	}
	public void setCoachingName(String coachingName) {
		this.coachingName = coachingName;
	}
	public String getCoachingEmail() {
		return coachingEmail;
	}
	public void setCoachingEmail(String coachingEmail) {
		this.coachingEmail = coachingEmail;
	}
	public String getCoachingPassword() {
		return coachingPassword;
	}
	public void setCoachingPassword(String coachingPassword) {
		this.coachingPassword = coachingPassword;
	}
	public int getCoachingStatus() {
		return coachingStatus;
	}
	public void setCoachingStatus(int coachingStatus) {
		this.coachingStatus = coachingStatus;
	}
	public String getCoachingMobile() {
		return coachingMobile;
	}
	public void setCoachingMobile(String coachingMobile) {
		this.coachingMobile = coachingMobile;
	}
	public String getCoachingAddress() {
		return coachingAddress;
	}
	public void setCoachingAddress(String coachingAddress) {
		this.coachingAddress = coachingAddress;
	}
	public String getCoachingOwner() {
		return coachingOwner;
	}
	public void setCoachingOwner(String coachingOwner) {
		this.coachingOwner = coachingOwner;
	}
	public String getCoachingPicUrl() {
		return coachingPicUrl;
	}
	public void setCoachingPicUrl(String coachingPicUrl) {
		this.coachingPicUrl = coachingPicUrl;
	}
	public String getCoachingPicId() {
		return coachingPicId;
	}
	public void setCoachingPicId(String coachingPicId) {
		this.coachingPicId = coachingPicId;
	}
	public String getCoachingStars() {
		return coachingStars;
	}
	public void setCoachingStars(String coachingStars) {
		this.coachingStars = coachingStars;
	}
	public List<Course> getCoachingCourses() {
		return coachingCourses;
	}
	public void setCoachingCourses(List<Course> coachingCourses) {
		this.coachingCourses = coachingCourses;
	}
	public Coaching(int coachingid, @NotNull String coachingName, @NotNull String coachingEmail,
			@NotNull String coachingPassword, @NotNull int coachingStatus, @NotNull String coachingMobile,
			@NotNull String coachingAddress, @NotNull String coachingOwner, @NotNull String coachingPicUrl,
			@NotNull String coachingPicId, @NotNull String coachingStars, List<Course> coachingCourses) {
		super();
		this.coachingId = coachingid;
		this.coachingName = coachingName;
		this.coachingEmail = coachingEmail;
		this.coachingPassword = coachingPassword;
		this.coachingStatus = coachingStatus;
		this.coachingMobile = coachingMobile;
		this.coachingAddress = coachingAddress;
		this.coachingOwner = coachingOwner;
		this.coachingPicUrl = coachingPicUrl;
		this.coachingPicId = coachingPicId;
		this.coachingStars = coachingStars;
		this.coachingCourses = coachingCourses;
	}
	public Coaching() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Coaching [coachingId=" + coachingId + ", coachingName=" + coachingName + ", coachingEmail="
				+ coachingEmail + ", coachingPassword=" + coachingPassword + ", coachingStatus=" + coachingStatus
				+ ", coachingMobile=" + coachingMobile + ", coachingAddress=" + coachingAddress + ", coachingOwner="
				+ coachingOwner + ", coachingPicUrl=" + coachingPicUrl + ", coachingPicId=" + coachingPicId
				+ ", coachingStars=" + coachingStars + ", coachingCourses=" + coachingCourses + "]";
	}

	
	
}
