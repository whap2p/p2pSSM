package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Certifrecord;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface CertifrecordMapper {
    int deleteByPrimaryKey(Integer crid);

    int insert(Certifrecord record);

    int insertSelective(Certifrecord record);

    Certifrecord selectByPrimaryKey(Integer crid);

    int updateByPrimaryKeySelective(Certifrecord record);

    int updateByPrimaryKey(Certifrecord record);

    List queryCertifrecord(HashMap<String,Object> map);
}