package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Dope;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DhDopeServiec {
    int deleteByPrimaryKey(Integer did);

    int insertSelective(Dope record);

    Dope selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Dope record);

    List<Dope> qureyDopePager(int dprimkey, PageBean pageBean);

}