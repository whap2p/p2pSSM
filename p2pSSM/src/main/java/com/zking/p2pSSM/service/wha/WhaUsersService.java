package com.zking.p2pSSM.service.wha;


import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface WhaUsersService {
    /**
     * 根据条件分页查询
     * @param users
     * @param pageBean
     * @return
     */
    List queryUsersPager(Users users, PageBean pageBean);

    /**
     * 根据用户ID查询单个用户
     * @param uid
     * @return
     */
    Users selectByPrimaryKey(Integer uid);
}
