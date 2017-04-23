package com.fitbook.repository;

import java.util.List;

import com.fitbook.model.User;

public interface UserRepository {

	User findById(int id);

	User findBySsoId(String ssoId);

	void save(User user);

	void deleteBySsoId(String ssoId);

	List<User> findAll();

}
