package com.exampedia.exampedia_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{

	@Query(value="SELECT exam_course_id FROM exams_table WHERE exam_id = ?1",nativeQuery=true)
	int getIdOfCourseThisExamBelongsTo(int examId);
}
