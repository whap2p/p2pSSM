package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Approveitem;

public interface ApproveitemMapper {
    int deleteByPrimaryKey(Integer aiid);

    int insert(Approveitem record);

    int insertSelective(Approveitem record);

    Approveitem selectByPrimaryKey(Integer aiid);

    int updateByPrimaryKeySelective(Approveitem record);

    int updateByPrimaryKey(Approveitem record);
}