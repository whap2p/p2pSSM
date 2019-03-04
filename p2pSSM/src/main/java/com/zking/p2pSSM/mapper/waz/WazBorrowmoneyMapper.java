package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Borrowmoney;

public interface WazBorrowmoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrowmoney record);

    int insertSelective(Borrowmoney record);

    Borrowmoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrowmoney record);

    int updateByPrimaryKey(Borrowmoney record);

}