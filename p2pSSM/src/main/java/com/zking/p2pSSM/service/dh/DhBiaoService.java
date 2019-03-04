package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.DhBiao;

import java.util.List;

public interface DhBiaoService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(DhBiao record);

    DhBiao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DhBiao record);

    List<DhBiao> queryBiao();

}