package com.exampedia.exampedia_api.projections;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.exampedia.exampedia_api.model.Exam;
import com.exampedia.exampedia_api.model.Pdf;
import com.exampedia.exampedia_api.model.Video;

public interface ProjectedCourses {

	int getCourseId();
	String getCourseName();
	String getCourseSyllabus();
	String getCourseSubjects();
	String getCourseDescription();
	String getCourseFees();
	String getCourseHours();
	String getCourseProffessors();
	List<ProjectedExam> getCourseExams();
	List<ProjectedPdf> getCoursePdfs();
	List<ProjectedVideos> getCourseVideos();
}
