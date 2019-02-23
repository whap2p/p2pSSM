package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Trade;

public interface TradeMapper {
    int deleteByPrimaryKey(Integer tID);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Integer tID);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);
}