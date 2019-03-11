package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.clapplyfor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface clapplyforMapper {
    int deleteByPrimaryKey(Integer clpid);

    int insert(clapplyfor record);

    int insertSelective(clapplyfor record);

    clapplyfor selectByPrimaryKey(Integer clpid);

    int updateByPrimaryKeySelective(clapplyfor record);

    int updateByPrimaryKey(clapplyfor record);

    List queryClapplyfors(HashMap<String,Object> map);
}