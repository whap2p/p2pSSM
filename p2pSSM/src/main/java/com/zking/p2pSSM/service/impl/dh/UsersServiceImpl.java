package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.UsersMapper;
import com.zking.p2pSSM.model.dh.Users;
import com.zking.p2pSSM.service.dh.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 9:48
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return usersMapper.deleteByPrimaryKey(uid);
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
    public int getId() {
        return usersMapper.getId();
    }

    @Override
    public Users qureyByName(String unickname) {
        return usersMapper.qureyByName(unickname);
    }
}
