package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Investinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DhInvestinfoMapper {
    int deleteByPrimaryKey(Integer inid);

    int insert(Investinfo record);

    int insertSelective(Investinfo record);

    Investinfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(Investinfo record);

    int updateByPrimaryKey(Investinfo record);

    List<Investinfo> qureyInvestinfo(int userid);
}