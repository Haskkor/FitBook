package com.fitbook.service;

import java.util.List;

import com.fitbook.model.UserProfile;

public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);

	List<UserProfile> findAll();

}
