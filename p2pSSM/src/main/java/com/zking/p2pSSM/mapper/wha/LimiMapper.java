package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Limi;

public interface LimiMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Limi record);

    int insertSelective(Limi record);

    Limi selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Limi record);

    int updateByPrimaryKey(Limi record);
}