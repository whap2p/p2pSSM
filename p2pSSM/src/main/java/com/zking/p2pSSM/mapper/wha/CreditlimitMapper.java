package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Creditlimit;

public interface CreditlimitMapper {
    int deleteByPrimaryKey(Integer clid);

    int insert(Creditlimit record);

    int insertSelective(Creditlimit record);

    Creditlimit selectByPrimaryKey(Integer clid);

    int updateByPrimaryKeySelective(Creditlimit record);

    int updateByPrimaryKey(Creditlimit record);
}