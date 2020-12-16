package com.exampedia.exampedia_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampedia.exampedia_api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
