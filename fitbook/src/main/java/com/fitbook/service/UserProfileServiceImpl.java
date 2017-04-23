package com.fitbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitbook.model.UserProfile;
import com.fitbook.repository.UserProfileRepository;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;

	/**
	 * Finds a profile by its id
	 */
	public UserProfile findById(int id) {
		return userProfileRepository.findById(id);
	}

	/**
	 * Finds a profile by its type
	 */
	public UserProfile findByType(String type) {
		return userProfileRepository.findByType(type);
	}

	/**
	 * Finds all profiles
	 */
	public List<UserProfile> findAll() {
		return userProfileRepository.findAll();
	}
}
