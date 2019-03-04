package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Investstat;
import org.springframework.stereotype.Repository;

@Repository
public interface DhInveststatMapper {
    int deleteByPrimaryKey(Integer isid);

    int insert(Investstat record);

    int insertSelective(Investstat record);

    Investstat selectByPrimaryKey(Integer isid);

    int updateByPrimaryKeySelective(Investstat record);

    int updateByPrimaryKey(Investstat record);

    Investstat queryByuserid(Integer userid);
}