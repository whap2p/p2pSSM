package com.zking.p2pSSM.service.hhj;

import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

/**
 * @author标题
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2019-03-06 20:29
 */
public interface IProductService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> ProductshowPager(Product record, PageBean pageBean);
}
