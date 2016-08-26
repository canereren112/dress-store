package com.eren.dstore.service;

import com.eren.dstore.entity.User;

public interface UserService {
	public User getUser(long id);

	public User getUserWithUserName(String userName);
}
