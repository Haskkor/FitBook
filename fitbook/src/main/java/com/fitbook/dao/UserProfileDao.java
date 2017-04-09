package com.fitbook.dao;

import java.util.List;

import com.fitbook.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}