package com.exampedia.exampedia_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer>{

}
