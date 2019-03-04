package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Trade;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TradeMapper {
    int deleteByPrimaryKey(Integer tID);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Integer tID);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);

    List queryTradelist(Map<String, Object> map);
}