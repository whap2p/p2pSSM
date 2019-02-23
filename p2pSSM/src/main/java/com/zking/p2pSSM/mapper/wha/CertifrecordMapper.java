package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Certifrecord;

public interface CertifrecordMapper {
    int deleteByPrimaryKey(Integer crid);

    int insert(Certifrecord record);

    int insertSelective(Certifrecord record);

    Certifrecord selectByPrimaryKey(Integer crid);

    int updateByPrimaryKeySelective(Certifrecord record);

    int updateByPrimaryKey(Certifrecord record);
}