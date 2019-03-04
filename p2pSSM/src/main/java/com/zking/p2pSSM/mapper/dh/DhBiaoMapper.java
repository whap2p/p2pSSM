package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Biao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DhBiaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Biao record);

    int insertSelective(Biao record);

    Biao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Biao record);

    int updateByPrimaryKey(Biao record);

    List<Biao> queryBiao();
}