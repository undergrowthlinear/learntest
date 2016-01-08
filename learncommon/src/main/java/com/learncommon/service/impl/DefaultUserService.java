package com.learncommon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncommon.dao.UserDao;
import com.learncommon.service.UserService;

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
