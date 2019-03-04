package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.DhTrade;

import java.util.List;
import java.util.Map;

public interface DhTradeService {
    int deleteByPrimaryKey(Integer tID);

    int insert(DhTrade record);

    DhTrade selectByPrimaryKey(Integer tID);

    int updateByPrimaryKeySelective(DhTrade record);

    List<DhTrade> queryTrade(Map<String, Object> map);
}