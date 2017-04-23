package com.fitbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fitbook.dao.UserDao;
import com.fitbook.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	/**
	 * Finds a user by its id
	 */
	public User findById(int id) {
		return dao.findById(id);
	}

	/**
	 * Finds a user by its SSOid
	 */
	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	/**
	 * Persists a user
	 */
	public void saveUser(User user) {
		dao.save(user);
	}

	/**
	 * Updates a user
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setSsoId(user.getSsoId());
			entity.setPassword(user.getPassword());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	/**
	 * Deletes a user
	 */
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	/**
	 * Finds all users
	 */
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	/**
	 * Returns a boolean telling if the given SSOid is unique
	 */
	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

}