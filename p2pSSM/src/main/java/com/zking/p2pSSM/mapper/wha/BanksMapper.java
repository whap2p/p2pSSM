package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Banks;

public interface BanksMapper {
    int deleteByPrimaryKey(Integer bkid);

    int insert(Banks record);

    int insertSelective(Banks record);

    Banks selectByPrimaryKey(Integer bkid);

    int updateByPrimaryKeySelective(Banks record);

    int updateByPrimaryKey(Banks record);
}