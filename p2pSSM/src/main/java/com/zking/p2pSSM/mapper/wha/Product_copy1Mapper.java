package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Product_copy1;

public interface Product_copy1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_copy1 record);

    int insertSelective(Product_copy1 record);

    Product_copy1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product_copy1 record);

    int updateByPrimaryKey(Product_copy1 record);
}