package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Tender;

public interface TenderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tender record);

    int insertSelective(Tender record);

    Tender selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tender record);

    int updateByPrimaryKey(Tender record);
}