package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.Withdrawal;

public interface DhWithdrawalService {
    int deleteByPrimaryKey(Integer wID);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

}