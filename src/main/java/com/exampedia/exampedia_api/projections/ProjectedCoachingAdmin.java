package com.exampedia.exampedia_api.projections;

import java.util.List;

import com.exampedia.exampedia_api.model.Course;

public interface ProjectedCoachingAdmin {
	
	int getCoachingId();
	String getCoachingName();
	String getCoachingEmail();
	int getCoachingStatus();
	String getCoachingMobile();
	String getCoachingAddress();
	String getCoachingOwner();
	byte[] getCoachingPicByte();
	String getCoachingPicType();
	String getCoachingStars();
	List<Course> getCoachingCourses();
	
}
