package com.learncommon.mapper;

import com.learncommon.entity.GsmsContact;



public interface GsmsContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GsmsContact record);

    int insertSelective(GsmsContact record);

    GsmsContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GsmsContact record);

    int updateByPrimaryKey(GsmsContact record);
}