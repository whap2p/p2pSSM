package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Dope;

public interface DopeMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Dope record);

    int insertSelective(Dope record);

    Dope selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Dope record);

    int updateByPrimaryKey(Dope record);
}