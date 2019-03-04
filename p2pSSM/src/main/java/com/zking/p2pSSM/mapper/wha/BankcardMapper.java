package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Bankcard;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface BankcardMapper {
    int deleteByPrimaryKey(Integer bID);

    int insert(Bankcard record);

    int insertSelective(Bankcard record);

    Bankcard selectByPrimaryKey(Integer bID);

    int updateByPrimaryKeySelective(Bankcard record);

    int updateByPrimaryKey(Bankcard record);

    List queryBankcard(HashMap<String, Object> map);
}