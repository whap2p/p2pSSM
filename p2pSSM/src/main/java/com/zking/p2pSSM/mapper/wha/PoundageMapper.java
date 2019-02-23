package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Poundage;

public interface PoundageMapper {
    int deleteByPrimaryKey(Integer pID);

    int insert(Poundage record);

    int insertSelective(Poundage record);

    Poundage selectByPrimaryKey(Integer pID);

    int updateByPrimaryKeySelective(Poundage record);

    int updateByPrimaryKey(Poundage record);
}