package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Inactiveuser;

public interface InactiveuserMapper {
    int deleteByPrimaryKey(Integer iid);

    int insert(Inactiveuser record);

    int insertSelective(Inactiveuser record);

    Inactiveuser selectByPrimaryKey(Integer iid);

    int updateByPrimaryKeySelective(Inactiveuser record);

    int updateByPrimaryKey(Inactiveuser record);
}