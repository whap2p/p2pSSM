package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhBiaoMapper;
import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.service.dh.DhBiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-03-02 10:20
 */
@Service
public class DhBiaoServiceImpl implements DhBiaoService {
    @Autowired
    private DhBiaoMapper dhBiaoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dhBiaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Biao record) {
        return dhBiaoMapper.insertSelective(record);
    }

    @Override
    public Biao selectByPrimaryKey(Integer id) {
        return dhBiaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Biao record) {
        return dhBiaoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Biao> queryBiao() {
        return dhBiaoMapper.queryBiao();
    }
}
