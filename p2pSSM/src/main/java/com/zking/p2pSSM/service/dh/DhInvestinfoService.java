package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Investinfo;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DhInvestinfoService {
    int deleteByPrimaryKey(Integer inid);

    int insertSelective(Investinfo record);

    Investinfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(Investinfo record);

    List<Investinfo> qureyInvestinfoPager(int userid, PageBean pageBean);

}