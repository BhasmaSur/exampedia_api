package com.exampedia.exampedia_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampedia.exampedia_api.model.User;
import com.exampedia.exampedia_api.projections.ProjectedUser;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
