package com.fitbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitbook.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findBySsoId(String ssoId);

	void deleteBySsoId(String ssoId);

}
