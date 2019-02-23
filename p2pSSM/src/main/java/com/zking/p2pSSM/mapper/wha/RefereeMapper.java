package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Referee;

public interface RefereeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Referee record);

    int insertSelective(Referee record);

    Referee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Referee record);

    int updateByPrimaryKey(Referee record);
}