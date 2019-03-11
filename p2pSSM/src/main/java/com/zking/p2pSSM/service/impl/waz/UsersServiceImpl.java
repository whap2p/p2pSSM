package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazUsersMapper;
import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.UsersService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private WazUsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return 0;
    }

    @Override
    public int insert(Users record) {
        return 0;
    }

    @Override
    public int insertSelective(Users record) {
        return 0;
    }

    @Override
    public List<Users> selectPager() {
        return usersMapper.selectByPrimaryKey();
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return 0;
    }

    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }

    @Override
    public int userCount() {
        return usersMapper.userCount();
    }

    @Override
    public int userCountByMarkmoney() {
        return usersMapper.userCountByMarkmoney();
    }

    @Override
    public int userCountByMarkgain() {
        return usersMapper.userCountByMarkgain();
    }


}
