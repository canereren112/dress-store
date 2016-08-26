package com.eren.dstore.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.dstore.dao.UserDao;
import com.eren.dstore.entity.User;

@Repository
public class UserDaoJpa extends BaseDaoJpa<User> implements UserDao {
	public User getUserWithUserName(String userName) {
		List<User> users = getEntityManager().createQuery("from User u where u.userName=?1")
				.setParameter(1, userName).getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}
}
