package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.dh.Users;

public interface UsersService {
    int deleteByPrimaryKey(Integer uid);


    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int getId();

    Users qureyByName(String unickname);

}