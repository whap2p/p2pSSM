package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Userauditor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserauditorMapper {
    int deleteByPrimaryKey(Integer uaid);

    int insert(Userauditor record);

    int insertSelective(Userauditor record);

    List queryUserauditor(HashMap<String, Object> map);
}