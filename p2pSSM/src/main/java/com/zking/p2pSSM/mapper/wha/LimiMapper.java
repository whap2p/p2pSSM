package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Limi;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LimiMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Limi record);

    int insertSelective(Limi record);

    Limi selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(Limi record);

    int updateByPrimaryKey(Limi record);

    List queryLimi(Limi limi);
}