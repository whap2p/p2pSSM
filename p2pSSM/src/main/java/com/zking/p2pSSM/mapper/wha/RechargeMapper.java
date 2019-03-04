package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Recharge;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface RechargeMapper {
    int deleteByPrimaryKey(Integer rID);

    int insert(Recharge record);

    int insertSelective(Recharge record);

    Recharge selectByPrimaryRechargeKey(Integer rID);

    int updateByPrimaryKeySelective(Recharge record);

    int updateByPrimaryKey(Recharge record);

    List queryRecharge(HashMap<String, Object> map);
}