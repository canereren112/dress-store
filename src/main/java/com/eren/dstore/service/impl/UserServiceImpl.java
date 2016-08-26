package com.eren.assignment.sahibinden.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eren.assignment.sahibinden.dao.UserDao;
import com.eren.assignment.sahibinden.entity.User;
import com.eren.assignment.sahibinden.service.UserService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public User getUser(long id) {
		return userDao.findById(id);
	}

	public User getUserWithUserName(String userName) {
		return userDao.getUserWithUserName(userName);
	}
}
