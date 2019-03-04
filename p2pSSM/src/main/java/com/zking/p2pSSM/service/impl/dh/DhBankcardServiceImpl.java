package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.DhBankcardMapper;
import com.zking.p2pSSM.model.dh.Bankcard;
import com.zking.p2pSSM.service.dh.DhBankcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-27 14:08
 */
@Service
public class DhBankcardServiceImpl implements DhBankcardService {
    @Autowired
    private DhBankcardMapper bankcardMapper;
    @Override
    public int deleteByPrimaryKey(Integer bID) {
        return bankcardMapper.deleteByPrimaryKey(bID);
    }

    @Override
    public int insertSelective(Bankcard record) {
        return bankcardMapper.insertSelective(record);
    }

    @Override
    public Bankcard selectByPrimaryKey(Integer bID) {
        return bankcardMapper.selectByPrimaryKey(bID);
    }

    @Override
    public int updateByPrimaryKeySelective(Bankcard record) {
        return bankcardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Bankcard qureyBysfz(String sfz) {
        return bankcardMapper.qureyBysfz(sfz);
    }
}
