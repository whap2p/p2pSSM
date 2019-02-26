package com.zking.p2pSSM.service.wha;


import com.zking.p2pSSM.model.Withdrawal;

import java.util.List;

public interface WithrawalService {
    int deleteByPrimaryKey(Integer wID);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);

    List queryWithdrawal(Withdrawal withdrawal);
}
