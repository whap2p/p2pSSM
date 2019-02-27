package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.service.wha.WithrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WithrawalServiceImpl implements WithrawalService {
    @Autowired
    WithrawalService withrawalService;
    @Override
    public int deleteByPrimaryKey(Integer wID) {
        return withrawalService.deleteByPrimaryKey(wID);
    }

    @Override
    public int insert(Withdrawal record) {
        return withrawalService.insert(record);
    }

    @Override
    public int insertSelective(Withdrawal record) {
        return withrawalService.insertSelective(record);
    }

    @Override
    public Withdrawal selectByPrimaryKey(Integer wID) {
        return withrawalService.selectByPrimaryKey(wID);
    }

    @Override
    public int updateByPrimaryKeySelective(Withdrawal record) {
        return withrawalService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Withdrawal record) {
        return withrawalService.updateByPrimaryKey(record);
    }

    @Override
    public List queryWithdrawal(Withdrawal withdrawal) {
        return withrawalService.queryWithdrawal(withdrawal);
    }
}
