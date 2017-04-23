package com.fitbook.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.fitbook.model.User;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractRepository<Integer, User> implements UserRepository {

	/**
	 * Finds a user by its id
	 */
	public User findById(int id) {
		User user = getByKey(id);
		if (user != null) {
			initializeCollection(user.getUserProfiles());
		}
		return user;
	}

	/**
	 * Finds a user by its SSO
	 */
	public User findBySsoId(String ssoId) {
		System.out.println("SSO : " + ssoId);
		try {
			User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
					.setParameter("ssoId", ssoId).getSingleResult();

			if (user != null) {
				initializeCollection(user.getUserProfiles());
			}
			return user;
		} catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Finds all users
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = getEntityManager().createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
				.getResultList();
		return users;
	}

	/**
	 * Persists a user
	 */
	public void save(User user) {
		persist(user);
	}

	/**
	 * Delete a user by its SSO
	 */
	public void deleteBySsoId(String ssoId) {
		User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
				.setParameter("ssoId", ssoId).getSingleResult();
		delete(user);
	}

	/**
	 * Alternative to Hibernate.initialize()
	 */
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

}
