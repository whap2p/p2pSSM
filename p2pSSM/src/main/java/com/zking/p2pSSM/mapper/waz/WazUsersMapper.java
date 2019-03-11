package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WazUsersMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByPrimaryKey();

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users login(Users users);

    /**
     *  查询总注册人数
     * @return
     */
    int userCount();

    /**
     * 主页查询累计投资金额
     * @return
     */
    int userCountByMarkmoney();

    /**
     * 主页查询累积收益
     * @return
     */
    int userCountByMarkgain();
}