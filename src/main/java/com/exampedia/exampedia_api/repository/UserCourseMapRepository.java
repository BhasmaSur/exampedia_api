package com.exampedia.exampedia_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.model.UserCourseMap;

public interface UserCourseMapRepository extends JpaRepository<UserCourseMap, Integer>{
	List<UserCourseMap> findByUserId(int userId);
}
