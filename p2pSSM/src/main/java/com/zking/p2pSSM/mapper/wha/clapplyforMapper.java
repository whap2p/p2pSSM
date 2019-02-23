package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.clapplyfor;

public interface clapplyforMapper {
    int deleteByPrimaryKey(Integer clpid);

    int insert(clapplyfor record);

    int insertSelective(clapplyfor record);

    clapplyfor selectByPrimaryKey(Integer clpid);

    int updateByPrimaryKeySelective(clapplyfor record);

    int updateByPrimaryKey(clapplyfor record);
}