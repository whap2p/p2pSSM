package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Testtb;

public interface TesttbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Testtb record);

    int insertSelective(Testtb record);

    Testtb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Testtb record);

    int updateByPrimaryKey(Testtb record);
}