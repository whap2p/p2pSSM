package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.DhInvestinfo;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DhInvestinfoService {
    int deleteByPrimaryKey(Integer inid);

    int insertSelective(DhInvestinfo record);

    DhInvestinfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(DhInvestinfo record);

    List<DhInvestinfo> qureyInvestinfoPager(int userid,PageBean pageBean);

}