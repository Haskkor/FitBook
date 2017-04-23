package com.fitbook.repository;

import java.util.List;

import com.fitbook.model.UserProfile;

public interface UserProfileRepository {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}