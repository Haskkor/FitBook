package com.fitbook.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.fitbook.model.UserProfile;

@Repository("userProfileRepository")
public class UserProfileRepositoryImpl extends AbstractRepository<Integer, UserProfile>
		implements UserProfileRepository {

	/**
	 * Finds a profile by its id
	 */
	public UserProfile findById(int id) {
		return getByKey(id);
	}

	/**
	 * Finds a profile by its type
	 */
	public UserProfile findByType(String type) {
		System.out.println("type: " + type);
		try {
			UserProfile userProfile = (UserProfile) getEntityManager()
					.createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type").setParameter("type", type)
					.getSingleResult();
			return userProfile;
		} catch (NoResultException ex) {
			return null;
		}
	}

	/**
	 * Finds all profiles
	 */
	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll() {
		List<UserProfile> userProfiles = getEntityManager()
				.createQuery("SELECT p FROM UserProfile p  ORDER BY p.type ASC").getResultList();
		return userProfiles;
	}
}
