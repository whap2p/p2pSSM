package com.zking.p2pSSM.service.wha;


import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface WithrawalService {
    int deleteByPrimaryKey(Integer wID);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer wID);

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);

    List queryWithdrawalPager(Map<String, Object> map, PageBean pageBean);

    int sumtxmoney();

    int sumdzmoney();

    int sumsxf();

    int updatedmoney(Map<String, Object> ma);

    int inserttmoney(Map<String, Object> ma);
}
