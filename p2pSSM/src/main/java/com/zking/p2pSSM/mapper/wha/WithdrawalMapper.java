package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Withdrawal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WithdrawalMapper {
    int deleteByPrimaryKey(Integer wID);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);

    List queryWithdrawal(Map<String, Object> map);

    int sumtxmoney();

    int sumdzmoney();

    int sumsxf();

    int updatedmoney(Map<String, Object> ma);

    int inserttmoney(Map<String, Object> ma);
}