package com.learnback.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**
	 * 统计用户类型
	 * @param type
	 * @return
	 */
	public int countTypeUser(@Param("type") int type);
}
