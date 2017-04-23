package com.fitbook.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.fitbook.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

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
	public User findBySSO(String sso) {
		System.out.println("SSO : " + sso);
		try {
			User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
					.setParameter("ssoId", sso).getSingleResult();

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
	public List<User> findAllUsers() {
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
	public void deleteBySSO(String sso) {
		User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
				.setParameter("ssoId", sso).getSingleResult();
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
