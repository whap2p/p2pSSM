package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhRechargeMapper;
import com.zking.p2pSSM.model.Recharge;
import com.zking.p2pSSM.service.dh.DhRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-03-01 11:01
 */
@Service
public class DhRechargeServiceImpl implements DhRechargeService {
    @Autowired
    private DhRechargeMapper dhRechargeMapper;
    @Override
    public int deleteByPrimaryKey(Integer rID) {
        return dhRechargeMapper.deleteByPrimaryKey(rID);
    }

    @Override
    public int insertSelective(Recharge record) {
        return dhRechargeMapper.insertSelective(record);
    }

    @Override
    public Recharge selectByPrimaryKey(Integer rID) {
        return dhRechargeMapper.selectByPrimaryKey(rID);
    }

    @Override
    public int updateByPrimaryKeySelective(Recharge record) {
        return dhRechargeMapper.updateByPrimaryKeySelective(record);
    }
}
