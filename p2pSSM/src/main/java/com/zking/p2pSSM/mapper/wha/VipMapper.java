package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Vip;

public interface VipMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);
}