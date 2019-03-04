package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.UsersMapper;
import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.wha.WhaUsersService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class WhaUsersServiceImpl implements WhaUsersService {
     @Autowired
    UsersMapper usersMapper;

    @Override
    public List queryUsersPager(Users users, PageBean pageBean) {
        return usersMapper.queryUsers(users);
    }
}
