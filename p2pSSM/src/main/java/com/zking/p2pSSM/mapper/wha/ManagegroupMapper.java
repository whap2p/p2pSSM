package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Managegroup;

public interface ManagegroupMapper {
    int deleteByPrimaryKey(Integer adminserial);

    int insert(Managegroup record);

    int insertSelective(Managegroup record);

    Managegroup selectByPrimaryKey(Integer adminserial);

    int updateByPrimaryKeySelective(Managegroup record);

    int updateByPrimaryKey(Managegroup record);
}