package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface ProductService {
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
    List<Product> queryPager(Product product, PageBean pageBean);

    /**
     * 主页推荐项目
     * @param product
     * @return
     */
    List<Product> queryByTop(Product product);
}