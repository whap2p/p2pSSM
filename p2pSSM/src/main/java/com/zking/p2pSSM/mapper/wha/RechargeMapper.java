package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Recharge;

public interface RechargeMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);
}