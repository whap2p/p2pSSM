package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.DhRecharge;

public interface DhRechargeService {
    int deleteByPrimaryKey(Integer rID);

    int insertSelective(DhRecharge record);

    DhRecharge selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(DhRecharge record);

}