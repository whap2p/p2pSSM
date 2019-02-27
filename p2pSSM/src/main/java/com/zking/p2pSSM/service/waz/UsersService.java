package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Users;

public interface UsersService {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users login(Users users);

    /**
     *  查询总注册人数
     * @return
     */
    int userCount();
}