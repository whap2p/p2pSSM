package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Userauditor;

public interface UserauditorMapper {
    int deleteByPrimaryKey(Integer uaid);

    int insert(Userauditor record);

    int insertSelective(Userauditor record);

    Userauditor selectByPrimaryKey(Integer uaid);

    int updateByPrimaryKeySelective(Userauditor record);

    int updateByPrimaryKey(Userauditor record);
}