package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.DhDope;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DhDopeServiec {
    int deleteByPrimaryKey(Integer did);

    int insertSelective(DhDope record);

    DhDope selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(DhDope record);

    List<DhDope> qureyDopePager(int dprimkey,PageBean pageBean);

}