package com.learncommon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learncommon.dao.GsmsContactDao;
import com.learncommon.entity.GsmsContact;
import com.learncommon.service.GsmsContactService;

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
