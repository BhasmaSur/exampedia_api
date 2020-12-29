package com.exampedia.exampedia_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampedia.exampedia_api.model.Coaching;
import com.exampedia.exampedia_api.projections.ProjectedCoaching;
import com.exampedia.exampedia_api.projections.ProjectedCoachingAdmin;


public interface CoachingRepository extends JpaRepository<Coaching, Integer>{
	ProjectedCoachingAdmin findByCoachingEmail(String email);
	List<ProjectedCoaching> findByCoachingStatus(Integer status);
	ProjectedCoachingAdmin findByCoachingName(String coachingName);
	ProjectedCoaching findByCoachingId(int coachingId);
	Coaching getByCoachingId(int coachingId);
	Coaching getByCoachingEmail(String caohing);
}
