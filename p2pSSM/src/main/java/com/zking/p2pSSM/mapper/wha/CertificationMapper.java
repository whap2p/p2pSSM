package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Certification;

public interface CertificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Certification record);

    int insertSelective(Certification record);

    Certification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Certification record);

    int updateByPrimaryKey(Certification record);
}