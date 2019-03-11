package com.zking.p2pSSM.mapper.hhj;

import com.zking.p2pSSM.model.Investinfo;

public interface HhjInvestinfoMapper {
    int deleteByPrimaryKey(Integer inid);

    int insert(Investinfo record);

    int insertSelective(Investinfo record);

    Investinfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(Investinfo record);

    int updateByPrimaryKey(Investinfo record);
}