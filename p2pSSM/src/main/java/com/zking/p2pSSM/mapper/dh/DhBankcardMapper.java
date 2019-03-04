package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Bankcard;
import org.springframework.stereotype.Repository;

@Repository
public interface DhBankcardMapper {
    int deleteByPrimaryKey(Integer bID);

    int insert(Bankcard record);

    int insertSelective(Bankcard record);

    Bankcard selectByPrimaryKey(Integer bID);

    int updateByPrimaryKeySelective(Bankcard record);

    int updateByPrimaryKey(Bankcard record);

    Bankcard qureyBysfz(String sfz);
}