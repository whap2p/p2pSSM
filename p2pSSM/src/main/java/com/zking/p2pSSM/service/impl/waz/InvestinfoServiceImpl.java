package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazInvestinfoMapper;
import com.zking.p2pSSM.model.Investinfo;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestinfoServiceImpl implements InvestinfoService {

    @Autowired
    private WazInvestinfoMapper wazInvestinfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer inid) {
        return 0;
    }

    @Override
    public int insert(Investinfo record) {
        return 0;
    }

    @Override
    public int insertSelective(Investinfo record) {
        return 0;
    }

    @Override
    public Investinfo selectByPrimaryKey(Integer inid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Investinfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Investinfo record) {
        return 0;
    }

    @Override
    public List<Investinfo> queryPager(Investinfo investinfo, PageBean pageBean) {
        return wazInvestinfoMapper.query(investinfo);
    }
}
