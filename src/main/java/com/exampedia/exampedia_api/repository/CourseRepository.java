package com.exampedia.exampedia_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exampedia.exampedia_api.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

		@Query(value="SELECT course_coaching_id FROM courses_table WHERE course_id = ?1",nativeQuery=true)
		int getIdOfCoachingThisCourseBelongsTo(String courseId);

	
	Course findByCourseId(int courseId);
}
