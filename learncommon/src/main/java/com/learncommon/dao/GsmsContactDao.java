package com.learncommon.dao;

import com.learncommon.entity.GsmsContact;

public interface GsmsContactDao {
	
	GsmsContact selectByPrimaryKey(Integer id);
}
