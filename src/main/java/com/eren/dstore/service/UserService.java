package com.eren.assignment.sahibinden.service;

import com.eren.assignment.sahibinden.entity.User;

public interface UserService {
	public User getUser(long id);

	public User getUserWithUserName(String userName);
}
