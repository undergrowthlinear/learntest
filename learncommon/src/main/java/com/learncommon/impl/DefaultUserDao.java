package com.learncommon.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.learncommon.common.dao.CommonDao;
import com.learncommon.dao.UserDao;
import com.learncommon.mapper.UserMapper;

@Component
public class DefaultUserDao extends CommonDao implements UserDao {

	public int countTypeUser(int type) {
		// TODO Auto-generated method stub
		SqlSession session = getSqlSessionFactory().openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		try {
			int countUser = userMapper.countTypeUser(type);
			return countUser;
		} finally {
			session.close();
		}
	}

}
