package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Testtb1;

public interface Testtb1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testtb1 record);

    int insertSelective(Testtb1 record);

    Testtb1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testtb1 record);

    int updateByPrimaryKey(Testtb1 record);
}