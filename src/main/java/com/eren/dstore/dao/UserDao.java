package com.eren.dstore.dao;

import com.eren.dstore.entity.User;

public interface UserDao extends BaseDao<User> {
	public User getUserWithUserName(String userName);
}
