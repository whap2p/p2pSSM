package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Recharge;

public interface DhRechargeService {
    int deleteByPrimaryKey(Integer rID);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(Recharge record);

}