package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhTradeMapper;
import com.zking.p2pSSM.model.Trade;
import com.zking.p2pSSM.service.dh.DhTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-03-02 11:38
 */
@Service
public class DhTradeServiceImpl implements DhTradeService {
    @Autowired
    private DhTradeMapper dhTradeMapper;
    @Override
    public int deleteByPrimaryKey(Integer tID) {
        return 0;
    }

    @Override
    public int insert(Trade record) {
        return 0;
    }

    @Override
    public Trade selectByPrimaryKey(Integer tID) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Trade record) {
        return 0;
    }

    @Override
    public List<Trade> queryTrade(Map<String, Object> map) {
        return dhTradeMapper.queryTrade(map);
    }
}
