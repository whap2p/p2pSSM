package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Poundage;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface PoundageMapper {
    int deleteByPrimaryKey(Integer pID);

    int insert(Poundage record);

    int insertSelective(Poundage record);

    Poundage selectByPrimaryPoundageKey(Integer pID);

    int updateByPrimaryKeySelective(Poundage record);

    int updateByPrimaryKey(Poundage record);

    List queryPoundage(HashMap<String, Object> map);
}