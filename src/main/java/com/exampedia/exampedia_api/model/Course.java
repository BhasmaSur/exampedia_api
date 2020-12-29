package com.exampedia.exampedia_api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="courses_table")
@Table(name="courses_table")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private String courseSyllabus;
	private String courseSubjects;
	private String courseDescription;
	private String courseFees;
	private String courseHours;
	private String courseProffessors;
	
	@OneToMany(targetEntity=Exam.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="examCourseId",referencedColumnName="courseId")
	private List<Exam> courseExams;
	
	@OneToMany(targetEntity=Pdf.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="pdfCourseId",referencedColumnName="courseId")
	private List<Pdf> coursePdfs;
	
	@OneToMany(targetEntity=Video.class,cascade=CascadeType.MERGE)
	@JoinColumn(name="videoCourseId",referencedColumnName="courseId")
	private List<Video> courseVideos;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSyllabus() {
		return courseSyllabus;
	}
	public void setCourseSyllabus(String courseSyllabus) {
		this.courseSyllabus = courseSyllabus;
	}
	public String getCourseSubjects() {
		return courseSubjects;
	}
	public void setCourseSubjects(String courseSubjects) {
		this.courseSubjects = courseSubjects;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}
	public String getCourseHours() {
		return courseHours;
	}
	public void setCourseHours(String courseHours) {
		this.courseHours = courseHours;
	}
	public String getCourseProffessors() {
		return courseProffessors;
	}
	public void setCourseProffessors(String courseProffessors) {
		this.courseProffessors = courseProffessors;
	}

	public Course(int courseId, @NotNull String courseName, @NotNull String courseSyllabus,
			@NotNull String courseSubjects, @NotNull String courseDescription, @NotNull String courseFees,
			@NotNull String courseHours, @NotNull String courseProffessors, List<Exam> courseExams,
			List<Pdf> coursePdfs, List<Video> courseVideos) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseSyllabus = courseSyllabus;
		this.courseSubjects = courseSubjects;
		this.courseDescription = courseDescription;
		this.courseFees = courseFees;
		this.courseHours = courseHours;
		this.courseProffessors = courseProffessors;
		this.courseExams = courseExams;
		this.coursePdfs = coursePdfs;
		this.courseVideos = courseVideos;
	}
	
	public List<Exam> getCourseExams() {
		return courseExams;
	}
	public void setCourseExams(List<Exam> courseExams) {
		this.courseExams = courseExams;
	}
	public List<Pdf> getCoursePdfs() {
		return coursePdfs;
	}
	public void setCoursePdfs(List<Pdf> coursePdfs) {
		this.coursePdfs = coursePdfs;
	}
	public List<Video> getCourseVideos() {
		return courseVideos;
	}
	public void setCourseVideos(List<Video> courseVideos) {
		this.courseVideos = courseVideos;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
