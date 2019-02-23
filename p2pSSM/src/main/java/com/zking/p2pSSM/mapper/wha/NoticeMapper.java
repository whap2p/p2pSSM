package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Notice;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}