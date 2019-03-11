package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Trade;

import java.util.List;
import java.util.Map;

public interface DhTradeService {
    int deleteByPrimaryKey(Integer tID);

    int insert(Trade record);

    Trade selectByPrimaryKey(Integer tID);

    int updateByPrimaryKeySelective(Trade record);

    List<Trade> queryTrade(int uid);
}