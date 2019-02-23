package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Lockusertable;

public interface LockusertableMapper {
    int deleteByPrimaryKey(Integer lockingserial);

    int insert(Lockusertable record);

    int insertSelective(Lockusertable record);

    Lockusertable selectByPrimaryKey(Integer lockingserial);

    int updateByPrimaryKeySelective(Lockusertable record);

    int updateByPrimaryKey(Lockusertable record);
}