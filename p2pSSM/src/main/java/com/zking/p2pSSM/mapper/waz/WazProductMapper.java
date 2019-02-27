package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WazProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 投资列表查询
     * @param product
     * @return
     */
    List<Product> query(Product product);

    /**
     * 主页推荐项目
     * @param product
     * @return
     */
    List<Product> queryByTop(Product product);
}