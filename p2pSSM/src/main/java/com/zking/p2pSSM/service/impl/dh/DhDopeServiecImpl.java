package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhDopeMapper;
import com.zking.p2pSSM.model.dh.DhDope;
import com.zking.p2pSSM.service.dh.DhDopeServiec;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-03-01 18:22
 */
@Service
public class DhDopeServiecImpl implements DhDopeServiec {
    @Autowired
    private DhDopeMapper dhDopeMapper;
    @Override
    public int deleteByPrimaryKey(Integer did) {
        return dhDopeMapper.deleteByPrimaryKey(did);
    }

    @Override
    public int insertSelective(DhDope record) {
        return dhDopeMapper.insertSelective(record);
    }

    @Override
    public DhDope selectByPrimaryKey(Integer did) {
        return dhDopeMapper.selectByPrimaryKey(did);
    }

    @Override
    public int updateByPrimaryKeySelective(DhDope record) {
        return dhDopeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DhDope> qureyDopePager(int dprimkey,PageBean pageBean) {
        return dhDopeMapper.qureyDope(dprimkey);
    }
}
