package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.Investstat;

public interface InveststatService {
    int deleteByPrimaryKey(Integer isid);

    int insertSelective(Investstat record);

    Investstat selectByPrimaryKey(Integer isid);

    int updateByPrimaryKeySelective(Investstat record);

    Investstat queryByuserid(Integer userid);

}