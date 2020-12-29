package com.exampedia.exampedia_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.repository.UserRepository;
import com.exampedia.exampedia_api.unknown.MyUserDetail;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found: "+userName));
		return user.map(MyUserDetail::new).get();
	}
	public boolean addUserIntoDataBase(String email,String name,String password) {

		User user1 = new User(name,email,password,"NaN","NaN","NaN","NaN","NaN","NaN","USER",true);
		User res=userRepository.save(user1);
		if(res.getUserName().matches(name)) {
			return true;
		}
		else {
			return false;
		}	
	}
	public boolean checkForDublicateEmail(String userEmail) {
		Optional<User> user=userRepository.findByEmail(userEmail);
		if(user.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}
	public Optional<User> updateUser(User userData){
		User user=userRepository.save(userData);
		return Optional.of(user) ;
	}

}
