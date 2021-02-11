package com.exampedia.exampedia_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="user_course_map")
@Table(name="user_course_map")
public class UserCourseMap {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userId;
	private int courseId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public UserCourseMap(int userId, int courseId) {
		super();
		this.userId = userId;
		this.courseId = courseId;
	}
	
	public UserCourseMap(int id, int userId, int courseId) {
		super();
		this.id = id;
		this.userId = userId;
		this.courseId = courseId;
	}
	public UserCourseMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
