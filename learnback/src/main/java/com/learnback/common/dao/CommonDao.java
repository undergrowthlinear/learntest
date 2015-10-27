package com.learnback.common.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
* @Description: TODO(通用Dao 注入mybatis的SqlSessionFactory)
* @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
* @Date 2015年10月27日
* @Version 1.0.0
 */
public class CommonDao {
   
	private SqlSessionFactory sqlSessionFactory;

	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	@Autowired
	@Qualifier("outerSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	
}
