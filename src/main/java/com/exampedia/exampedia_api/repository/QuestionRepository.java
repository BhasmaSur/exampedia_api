package com.exampedia.exampedia_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exampedia.exampedia_api.model.Coaching;
import com.exampedia.exampedia_api.model.Question;
import com.exampedia.exampedia_api.projections.ProjectedQuestion;

public interface QuestionRepository  extends JpaRepository<Question, Integer>  {
	
	/*
	@Query(value="SELECT question_id,exam_id,marks,optiona,optionb,optionc,optiond,statement,type FROM questions_table WHERE exam_id = ?1",nativeQuery=true)
	List<ProjectedQuestion> getQuestionsForExamId(int examId);
	*/
	
	List<ProjectedQuestion> findByExamId(int examId);
}
