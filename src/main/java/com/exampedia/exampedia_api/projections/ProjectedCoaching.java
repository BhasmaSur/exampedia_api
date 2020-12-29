package com.exampedia.exampedia_api.projections;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.exampedia.exampedia_api.model.Course;

public interface ProjectedCoaching {

	int getCoachingId();
	String getCoachingName();
	String getCoachingEmail();
	int getCoachingStatus();
	String getCoachingMobile();
	String getCoachingAddress();
	String getCoachingOwner();
	String getCoachingPicUrl();
	String getCoachingPicId();
	String getCoachingStars();
	List<ProjectedCourses> getCoachingCourses();
	
}
