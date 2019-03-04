package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Recharge;
import org.springframework.stereotype.Repository;

@Repository
public interface DhRechargeMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryKey(Integer rID);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);
}