package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface UsersService {
    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectPager();

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