package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Userreport;

public interface UserreportMapper {
    int deleteByPrimaryKey(Integer reportserial);

    int insert(Userreport record);

    int insertSelective(Userreport record);

    Userreport selectByPrimaryKey(Integer reportserial);

    int updateByPrimaryKeySelective(Userreport record);

    int updateByPrimaryKey(Userreport record);
}