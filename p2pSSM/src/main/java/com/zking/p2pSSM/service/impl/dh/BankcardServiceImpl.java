package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.BankcardMapper;
import com.zking.p2pSSM.model.dh.Bankcard;
import com.zking.p2pSSM.service.dh.BankcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-27 14:08
 */
@Service
public class BankcardServiceImpl implements BankcardService {
    @Autowired
    private BankcardMapper bankcardMapper;
    @Override
    public int deleteByPrimaryKey(Integer bID) {
        return 0;
    }

    @Override
    public int insertSelective(Bankcard record) {
        return 0;
    }

    @Override
    public Bankcard selectByPrimaryKey(Integer bID) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Bankcard record) {
        return 0;
    }

    @Override
    public Bankcard qureyBysfz(String sfz) {
        return bankcardMapper.qureyBysfz(sfz);
    }
}
