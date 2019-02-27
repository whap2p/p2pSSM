package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazBiaoMapper;
import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.service.waz.BiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiaoServiceImpl implements BiaoService {

    @Autowired
    private WazBiaoMapper wazBiaoMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Biao record) {
        return 0;
    }

    @Override
    public int insertSelective(Biao record) {
        return 0;
    }

    @Override
    public Biao selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Biao record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Biao record) {
        return 0;
    }

    @Override
    public List<Biao> query() {
        return wazBiaoMapper.query();
    }
}
