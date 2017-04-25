package com.fitbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitbook.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

	UserProfile findByType(String type);

}