package com.zking.p2pSSM.service.impl.hhj;

import com.zking.p2pSSM.mapper.hhj.hhjProductMapper;
import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.service.hhj.IProductService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author标题
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2019-03-06 20:31
 */
@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private hhjProductMapper hhjProductMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return hhjProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return hhjProductMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return hhjProductMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return hhjProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return hhjProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return hhjProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> ProductshowPager(Product record, PageBean pageBean) {
        return hhjProductMapper.Productshow(record);
    }
}
