package com.learnback.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.learnback.common.dao.CommonDao;
import com.learnback.dao.GsmsContactDao;
import com.learnback.dao.UserDao;
import com.learnback.entity.GsmsContact;
import com.learnback.mapper.GsmsContactMapper;
import com.learnback.mapper.UserMapper;

@Component
public class DefaultGsmsContactDao extends CommonDao implements GsmsContactDao {

	@Override
	public GsmsContact selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSessionFactory().openSession();
		GsmsContactMapper contactMapper = session.getMapper(GsmsContactMapper.class);
		try {
			GsmsContact contact=contactMapper.selectByPrimaryKey(id);
			return contact;
		} finally {
			session.close();
		}
	}

	
}
