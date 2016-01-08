package com.learncommon.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.learncommon.common.dao.CommonDao;
import com.learncommon.dao.GsmsContactDao;
import com.learncommon.dao.UserDao;
import com.learncommon.entity.GsmsContact;
import com.learncommon.mapper.GsmsContactMapper;
import com.learncommon.mapper.UserMapper;

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
