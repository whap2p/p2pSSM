package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Approveitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ApproveitemMapper {
    int deleteByPrimaryKey(Integer aiid);

    int insert(Approveitem record);

    int insertSelective(Approveitem record);

    Approveitem selectByPrimaryKey(Integer aiid);

    int updateByPrimaryKeySelective(Approveitem record);

    int updateByPrimaryKey(Approveitem record);

    List queryApproves(HashMap<String,Object> map);
}