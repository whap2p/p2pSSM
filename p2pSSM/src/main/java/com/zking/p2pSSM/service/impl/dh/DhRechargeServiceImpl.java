package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhRechargeMapper;
import com.zking.p2pSSM.model.dh.DhRecharge;
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
    public int insertSelective(DhRecharge record) {
        return dhRechargeMapper.insertSelective(record);
    }

    @Override
    public DhRecharge selectByPrimaryKey(Integer rID) {
        return dhRechargeMapper.selectByPrimaryKey(rID);
    }

    @Override
    public int updateByPrimaryKeySelective(DhRecharge record) {
        return dhRechargeMapper.updateByPrimaryKeySelective(record);
    }
}
