package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Details;

public interface DetailsMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Details record);

    int insertSelective(Details record);

    Details selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Details record);

    int updateByPrimaryKey(Details record);
}