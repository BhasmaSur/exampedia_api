package com.exampedia.exampedia_api.data_provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.repository.UserRepository;

@Component
public class CreateDummyUsers {

	@Autowired
	UserRepository userRepository;

	public CreateDummyUsers() {

	}
	
	public void addUsers() {
		/*
		User user1 = new User(1,"shamu chauhan","shamu@gmail.com","shamu123","12/17/2020","NaN","NaN","NaN","NaN","NaN","USER",true);
		User user2 = new User(2,"chomu chauhan","chomu@gmail.com","chomu123","12/17/2020","NaN","NaN","NaN","NaN","NaN","USER",true);
		User user3 = new User(3,"sanjay yadav","sanjay@gmail.com","sanjay123","12/17/2020","NaN","NaN","NaN","NaN","NaN","USER",true);
		User user4 = new User(4,"jhomu chauhan","jhomu@gmail.com","jhomu123","12/17/2020","NaN","NaN","NaN","NaN","NaN","USER",true);
		User user5 = new User(5,"tomu chauhan","tomu@gmail.com","tomu123","12/17/2020","NaN","NaN","NaN","NaN","NaN","USER",true);
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		*/
	}

}
