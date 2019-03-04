package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazDetailsMapper;
import com.zking.p2pSSM.model.Details;
import com.zking.p2pSSM.service.waz.DetailsService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private WazDetailsMapper detailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return 0;
    }

    @Override
    public int insert(Details record) {
        return 0;
    }

    @Override
    public int insertSelective(Details record) {
        return 0;
    }

    @Override
    public Details selectByPrimaryKey(Integer did) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Details record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Details record) {
        return 0;
    }

    @Override
    public List<Details> queryPager(Details details, PageBean pageBean) {
        return detailsMapper.query(details);
    }
}
