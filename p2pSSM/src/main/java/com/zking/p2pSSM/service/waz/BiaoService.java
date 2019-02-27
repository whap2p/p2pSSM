package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Biao;

import java.util.List;

public interface BiaoService {
    int deleteByPrimaryKey(Integer id);

    int insert(Biao record);

    int insertSelective(Biao record);

    Biao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Biao record);

    int updateByPrimaryKey(Biao record);

    List<Biao> query();
}