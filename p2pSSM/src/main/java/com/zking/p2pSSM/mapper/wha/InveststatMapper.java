package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Investstat;

public interface InveststatMapper {
    int deleteByPrimaryKey(Integer isid);

    int insert(Investstat record);

    int insertSelective(Investstat record);

    Investstat selectByPrimaryKey(Integer isid);

    int updateByPrimaryKeySelective(Investstat record);

    int updateByPrimaryKey(Investstat record);
}