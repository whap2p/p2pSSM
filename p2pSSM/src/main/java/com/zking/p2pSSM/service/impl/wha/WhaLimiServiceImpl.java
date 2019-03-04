package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.LimiMapper;
import com.zking.p2pSSM.model.Limi;
import com.zking.p2pSSM.service.wha.WhaLimiService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class WhaLimiServiceImpl implements WhaLimiService {
    @Autowired
    LimiMapper limiMapper;

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return limiMapper.deleteByPrimaryKey(did);
    }

    @Override
    public int insertSelective(Limi record) {
        return limiMapper.insertSelective(record);
    }

    @Override
    public List queryLimiPager(Limi limi, PageBean pageBean) {
        return limiMapper.queryLimi(limi);
    }
}
