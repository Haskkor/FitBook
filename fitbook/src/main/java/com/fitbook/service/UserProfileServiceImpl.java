package com.fitbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitbook.dao.UserProfileDao;
import com.fitbook.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao dao;

	/**
	 * Finds a profile by its id
	 */
	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	/**
	 * Finds a profile by its type
	 */
	public UserProfile findByType(String type) {
		return dao.findByType(type);
	}

	/**
	 * Finds all profiles
	 */
	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
