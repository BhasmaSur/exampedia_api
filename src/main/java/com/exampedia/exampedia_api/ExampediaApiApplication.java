package com.exampedia.exampedia_api;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.exampedia.exampedia_api.data_provider.CreateDummyCoachings;
import com.exampedia.exampedia_api.data_provider.CreateDummyCourses;
import com.exampedia.exampedia_api.data_provider.CreateDummyUsers;
import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.repository.CoachingRepository;
import com.exampedia.exampedia_api.repository.CourseRepository;
import com.exampedia.exampedia_api.repository.ExamRepository;
import com.exampedia.exampedia_api.repository.PdfRepository;
import com.exampedia.exampedia_api.repository.UserRepository;
import com.exampedia.exampedia_api.repository.VideoRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class,CoachingRepository.class,CourseRepository.class
		,PdfRepository.class,VideoRepository.class,ExamRepository.class})
public class ExampediaApiApplication {
	
	public static void main(String[] args) {
		//SpringApplication.run(ExampediaApiApplication.class, args);
		ApplicationContext context =SpringApplication.run(ExampediaApiApplication.class, args);
		//UserRepository userRepository =  context.getBean(UserRepository.class);
		CreateDummyCoachings createDummyCoachings =  context.getBean(CreateDummyCoachings.class);
		CreateDummyUsers createDummyUsers =  context.getBean(CreateDummyUsers.class);
		createDummyCoachings.addCoachings();
		createDummyUsers.addUsers();
		//new CreateDummyCoachings(coachingRepository);
		
	}
	
	/*
	 * netstat -ano | findstr :8080
	 * taskkill /PID 8080 /F
	 * 
	 * 
	 * 
	 */

}
