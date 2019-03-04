package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhInvestinfoMapper;
import com.zking.p2pSSM.model.dh.DhInvestinfo;
import com.zking.p2pSSM.service.dh.DhInvestinfoService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-03-02 9:05
 */
@Service
public class DhInvestinfoServiceImpl implements DhInvestinfoService {
    @Autowired
    private DhInvestinfoMapper dhInvestinfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer inid) {
        return dhInvestinfoMapper.deleteByPrimaryKey(inid);
    }

    @Override
    public int insertSelective(DhInvestinfo record) {
        return dhInvestinfoMapper.insertSelective(record);
    }

    @Override
    public DhInvestinfo selectByPrimaryKey(Integer inid) {
        return dhInvestinfoMapper.selectByPrimaryKey(inid);
    }

    @Override
    public int updateByPrimaryKeySelective(DhInvestinfo record) {
        return dhInvestinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DhInvestinfo> qureyInvestinfoPager(int userid,PageBean pageBean) {
        return dhInvestinfoMapper.qureyInvestinfo(userid);
    }
}
