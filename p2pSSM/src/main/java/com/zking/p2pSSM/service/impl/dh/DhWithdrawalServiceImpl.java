package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhWithdrawalMapper;
import com.zking.p2pSSM.model.dh.Withdrawal;
import com.zking.p2pSSM.service.dh.DhWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-28 9:07
 */
@Service
public class DhWithdrawalServiceImpl implements DhWithdrawalService {
    @Autowired
    private DhWithdrawalMapper dhWithdrawalMapper;
    @Override
    public int deleteByPrimaryKey(Integer wID) {
        return dhWithdrawalMapper.deleteByPrimaryKey(wID);
    }

    @Override
    public int insertSelective(Withdrawal record) {
        return dhWithdrawalMapper.insertSelective(record);
    }

    @Override
    public Withdrawal selectByPrimaryKey(Integer wID) {
        return dhWithdrawalMapper.selectByPrimaryKey(wID);
    }

    @Override
    public int updateByPrimaryKeySelective(Withdrawal record) {
        return dhWithdrawalMapper.updateByPrimaryKeySelective(record);
    }
}
