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
		
		User user1 = new User(1,"shamu chauhan","shamu@gmail.com","shamu123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","USER",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user2 = new User(2,"chomu chauhan","chomu@gmail.com","chomu123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","USER",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user3 = new User(3,"sanjay yadav","sanjay@gmail.com","sanjay123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","USER",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user4 = new User(4,"jhomu chauhan","jhomu@gmail.com","jhomu123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","USER",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user5 = new User(5,"tomu chauhan","tomu@gmail.com","tomu123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","USER",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user6 = new User(6,"Rajeev yadav","rajeev@gmail.com","rajeev123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","COACHING",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user7 = new User(7,"Sanjay yadav","sanjay@gmail.com","sanjay123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","COACHING",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user8 = new User(8,"vishnu yadav","vishnu@gmail.com","vishnu123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","COACHING",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user9 = new User(9,"swapnil yadav","swapnil@gmail.com","swapnil123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","COACHING",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		User user10 = new User(10,"calcium sharma","calcium@gmail.com","calcium123","12/17/2020","NaN","NaN","NaN","NaN".getBytes(),"NaN","COACHING",true, "NaN", "NaN", "NaN", "NaN", "NaN");
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
		userRepository.save(user6);
		userRepository.save(user7);
		userRepository.save(user8);
		userRepository.save(user9);
		userRepository.save(user10);
		
	}

}
