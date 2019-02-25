package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     *   用户登陆
     * @param users
     * @return
     */
    Users queryByName(Users users);

    /**
     * 用户开户
     * @param users
     * @return
     */
    int updateByKH(Users users);
}