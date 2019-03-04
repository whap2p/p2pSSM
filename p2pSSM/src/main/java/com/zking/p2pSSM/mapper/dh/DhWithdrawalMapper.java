package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Withdrawal;
import org.springframework.stereotype.Repository;

@Repository
public interface DhWithdrawalMapper {
    int deleteByPrimaryKey(Integer wID);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);
}