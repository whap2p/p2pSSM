package com.zking.p2pSSM.service.waz.impl;

import com.zking.p2pSSM.mapper.waz.UsersMapper;
import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return usersMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer uid) {
        return usersMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public Users queryByNamePager(Users users) {
        return usersMapper.queryByName(users);
    }

    @Override
    public int updateByKH(Users users) {
        return usersMapper.updateByKH(users);
    }
}
