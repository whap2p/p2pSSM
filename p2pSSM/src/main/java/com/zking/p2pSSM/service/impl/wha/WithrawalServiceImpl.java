package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.WithdrawalMapper;
import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.service.wha.WithrawalService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WithrawalServiceImpl implements WithrawalService {
    @Autowired
    WithdrawalMapper withdrawalMapper;
    @Override
    public int deleteByPrimaryKey(Integer wID) {
        return withdrawalMapper.deleteByPrimaryKey(wID);
    }

    @Override
    public int insert(Withdrawal record) {
        return withdrawalMapper.insert(record);
    }

    @Override
    public int insertSelective(Withdrawal record) {
        return withdrawalMapper.insertSelective(record);
    }

    @Override
    public Withdrawal selectByPrimaryKey(Integer wID) {
        return withdrawalMapper.selectByPrimaryKey(wID);
    }

    @Override
    public int updateByPrimaryKeySelective(Withdrawal record) {
        return withdrawalMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Withdrawal record) {
        return withdrawalMapper.updateByPrimaryKey(record);
    }

    @Override
    public List queryWithdrawalPager(Map<String, Object> map, PageBean pageBean) {
        return withdrawalMapper.queryWithdrawal(map);
    }

    @Override
    public int sumtxmoney() {
        return withdrawalMapper.sumtxmoney();
    }

    @Override
    public int sumdzmoney() {
        return withdrawalMapper.sumdzmoney();
    }

    @Override
    public int sumsxf() {
        return withdrawalMapper.sumsxf();
    }

    @Override
    public int updatedmoney(Map<String, Object> ma) {
        return withdrawalMapper.updatedmoney(ma);
    }

    @Override
    public int inserttmoney(Map<String, Object> ma) {
        Withdrawal w= (Withdrawal) ma.get("wone");
        int i= (int) ma.get("i");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", w.getuID());
        map.put("uname", w.getUname());
        map.put("zname", w.getZname());
        map.put("jymoney",w.getTxmoney());
        if(i==0){
            map.put("what", "提现失败");
        }else if(i==1){
            map.put("what", "转账失败");
        }else if(i==2){
            map.put("what", "转账成功");
        }
        map.put("jytime", new Date());
        map.put("other", "无");
        return withdrawalMapper.inserttmoney(ma);
    }
}
