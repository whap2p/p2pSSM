package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Withdrawal;

public interface WithdrawalMapper {
    int deleteByPrimaryKey(Integer wID);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);
}