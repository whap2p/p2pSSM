package com.zking.p2pSSM.mapper.dh;

import com.zking.p2pSSM.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface DhUsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int getId();

    Users qureyByName(Users users);



}