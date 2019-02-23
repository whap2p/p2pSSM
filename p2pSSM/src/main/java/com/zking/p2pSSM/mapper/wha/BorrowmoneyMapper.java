package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Borrowmoney;

public interface BorrowmoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrowmoney record);

    int insertSelective(Borrowmoney record);

    Borrowmoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrowmoney record);

    int updateByPrimaryKey(Borrowmoney record);
}