package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Borrowmoney;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowmoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrowmoney record);

    int insertSelective(Borrowmoney record);

    Borrowmoney selectByPrimaryBorrowmoneyKey(Integer id);

    int updateByPrimaryKeySelective(Borrowmoney record);

    int updateByPrimaryKey(Borrowmoney record);

    List queryBorrowmoney(Borrowmoney borrowmoney);
}