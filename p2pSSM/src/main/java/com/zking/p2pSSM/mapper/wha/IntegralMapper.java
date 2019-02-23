package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Integral;

public interface IntegralMapper {
    int deleteByPrimaryKey(Integer cuserid);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Integer cuserid);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
}