package com.exampedia.exampedia_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exampedia.exampedia_api.model.Course;
import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserCourseMap;
import com.exampedia.exampedia_api.model.UserSignUpRequest;
import com.exampedia.exampedia_api.repository.CourseRepository;
import com.exampedia.exampedia_api.repository.UserCourseMapRepository;
import com.exampedia.exampedia_api.repository.UserRepository;
import com.exampedia.exampedia_api.unknown.MyUserDetail;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserCourseMapRepository userCourseMapRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found: "+userName));
		return user.map(MyUserDetail::new).get();
	}
	public boolean addUserIntoDataBase(String email,String name,String password,String role) {
		System.out.println("=================="+email+name+password+"=====================");
		User user1 = new User(name,email,password,"NaN","NaN","NaN","NaN","NaN".getBytes(),"NaN",role,true,"NaN","NaN","NaN","NaN","NaN");
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
		if(!user.isPresent()) {
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
	public List<UserCourseMap> getCoursesSubscribedByUser(int userId){
		List<UserCourseMap> userCourseMap=userCourseMapRepository.findByUserId(userId);
		return userCourseMap;
	}
	public List<Course> getCourseDetailSubscibedByUser(List<UserCourseMap> userCourseMap){
		List<Integer> ids= new ArrayList<>();
		for(int i=0; i < userCourseMap.size();i++) {
			ids.add(userCourseMap.get(i).getCourseId());
		}
		List<Course> courses = courseRepository.findAllById(ids);
		return courses;
	}

}
