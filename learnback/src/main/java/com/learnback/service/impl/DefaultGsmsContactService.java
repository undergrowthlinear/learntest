package com.learnback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnback.dao.GsmsContactDao;
import com.learnback.entity.GsmsContact;
import com.learnback.service.GsmsContactService;

@Service
public class DefaultGsmsContactService implements GsmsContactService {

	@Autowired
	private GsmsContactDao contactDao;

	@Override
	public GsmsContact selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return contactDao.selectByPrimaryKey(id);
	}

}
