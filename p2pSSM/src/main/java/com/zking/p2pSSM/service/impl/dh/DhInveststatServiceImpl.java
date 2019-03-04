package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhInveststatMapper;
import com.zking.p2pSSM.model.Investstat;
import com.zking.p2pSSM.service.dh.DhInveststatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 19:11
 */
@Service
public class DhInveststatServiceImpl implements DhInveststatService {
    @Autowired
    private DhInveststatMapper investstatMapper;
    @Override
    public int deleteByPrimaryKey(Integer isid) {
        return investstatMapper.deleteByPrimaryKey(isid);
    }

    @Override
    public int insertSelective(Investstat record) {
        return investstatMapper.insertSelective(record);
    }

    @Override
    public Investstat selectByPrimaryKey(Integer isid) {
        return investstatMapper.selectByPrimaryKey(isid);
    }

    @Override
    public int updateByPrimaryKeySelective(Investstat record) {
        return investstatMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Investstat queryByuserid(Integer userid) {
        return investstatMapper.queryByuserid(userid);
    }
}
