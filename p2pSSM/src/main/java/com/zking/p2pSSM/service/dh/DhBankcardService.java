package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Bankcard;
import org.springframework.stereotype.Repository;

@Repository
public interface DhBankcardService {
    int deleteByPrimaryKey(Integer bID);

    int insertSelective(Bankcard record);

    Bankcard selectByPrimaryKey(Integer bID);

    int updateByPrimaryKeySelective(Bankcard record);

    Bankcard qureyBysfz(String sfz);
}