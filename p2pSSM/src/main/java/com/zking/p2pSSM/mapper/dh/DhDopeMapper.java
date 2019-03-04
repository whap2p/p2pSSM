package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Dope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DhDopeMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Dope record);

    int insertSelective(Dope record);

    Dope selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Dope record);

    int updateByPrimaryKey(Dope record);

    List<Dope> qureyDope(int dprimkey);
}