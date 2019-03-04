package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhDopeMapper;
import com.zking.p2pSSM.model.Dope;
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
    public int insertSelective(Dope record) {
        return dhDopeMapper.insertSelective(record);
    }

    @Override
    public Dope selectByPrimaryKey(Integer did) {
        return dhDopeMapper.selectByPrimaryKey(did);
    }

    @Override
    public int updateByPrimaryKeySelective(Dope record) {
        return dhDopeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Dope> qureyDopePager(int dprimkey,PageBean pageBean) {
        return dhDopeMapper.qureyDope(dprimkey);
    }
}
