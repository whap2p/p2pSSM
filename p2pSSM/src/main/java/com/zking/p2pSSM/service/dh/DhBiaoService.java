package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Biao;

import java.util.List;

public interface DhBiaoService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Biao record);

    Biao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Biao record);

    List<Biao> queryBiao();

}