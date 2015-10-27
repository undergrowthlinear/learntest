package com.learnback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnback.dao.UserDao;
import com.learnback.service.UserService;

@Service
public class DefaultUserService implements UserService {

	private UserDao userDao;
	
	public int countTypeUser(int type) {
		// TODO Auto-generated method stub
		return userDao.countTypeUser(type);
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
