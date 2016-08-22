package com.eren.assignment.sahibinden.dao;

import com.eren.assignment.sahibinden.entity.User;

public interface UserDao extends BaseDao<User> {
	public User getUserWithUserName(String userName);
}
