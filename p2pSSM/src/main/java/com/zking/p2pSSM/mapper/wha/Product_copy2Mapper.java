package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Product_copy2;

public interface Product_copy2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_copy2 record);

    int insertSelective(Product_copy2 record);

    Product_copy2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product_copy2 record);

    int updateByPrimaryKey(Product_copy2 record);
}