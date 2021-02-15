package com.exampedia.exampedia_api.data_provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Coaching;
import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.Question;
import com.exampedia.exampedia_api.repository.CoachingRepository;
import com.exampedia.exampedia_api.repository.QuestionRepository;


@Component
public class CreateDummyCoachings {

	@Autowired
	CreateDummyQuestions createDummyQuestions;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	CreateDummyCourses createDummyCourses;
	
	@Autowired
	private CoachingRepository coachingRepository;
	
	public CreateDummyCoachings() {
		
	}
	
	public void addCoachings() {
				
		List<Question> questions=createDummyQuestions.getListOfDummyQuestions();
		questionRepository.saveAll(questions);
		
		
		List<Course> courses1=createDummyCourses.getDummyCoursesSet1();
		List<Course> courses2=createDummyCourses.getDummyCoursesSet2();
		
		Coaching coaching1 = new Coaching(1,"Rajeev yadav","rajeev@gmail.com","rajeev123",1,"000000000","NaN","Rajeev yadav","NaN".getBytes(),"NaN","0/5",courses1);
		Coaching coaching2 = new Coaching(2,"Sanjay yadav","sanjay@gmail.com","sanjay123",1,"000000000","NaN","Sanjay yadav","NaN".getBytes(),"NaN","0/5",courses2);
		Coaching coaching3 = new Coaching(3,"vishnu yadav","vishnu@gmail.com","vishnu123",1,"000000000","NaN","vishnu yadav","NaN".getBytes(),"NaN","0/5",courses2);
		Coaching coaching4 = new Coaching(4,"swapnil yadav","swapnil@gmail.com","swapnil123",1,"000000000","NaN","swapnil yadav","NaN".getBytes(),"NaN","0/5",courses2);
		Coaching coaching5 = new Coaching(5,"calcium sharma","calcium@gmail.com","calcium123",1,"000000000","NaN","calcium sharma","NaN".getBytes(),"NaN","0/5",courses2);
		coachingRepository.save(coaching1);
		coachingRepository.save(coaching2);
		coachingRepository.save(coaching3);
		coachingRepository.save(coaching4);
		coachingRepository.save(coaching5);
		
	}
}
