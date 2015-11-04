package com.learnback.dao;

import com.learnback.entity.GsmsContact;

public interface GsmsContactDao {
	
	GsmsContact selectByPrimaryKey(Integer id);
}
