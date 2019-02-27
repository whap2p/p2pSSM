package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.InveststatMapper;
import com.zking.p2pSSM.model.dh.Investstat;
import com.zking.p2pSSM.service.dh.InveststatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 19:11
 */
@Service
public class InveststatServiceImpl implements InveststatService {
    @Autowired
    private InveststatMapper investstatMapper;
    @Override
    public int deleteByPrimaryKey(Integer isid) {
        return 0;
    }

    @Override
    public int insertSelective(Investstat record) {
        return 0;
    }

    @Override
    public Investstat selectByPrimaryKey(Integer isid) {
        return investstatMapper.selectByPrimaryKey(isid);
    }

    @Override
    public int updateByPrimaryKeySelective(Investstat record) {
        return 0;
    }

    @Override
    public Investstat queryByuserid(Integer userid) {
        return investstatMapper.queryByuserid(userid);
    }
}
