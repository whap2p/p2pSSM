package com.zking.p2pSSM.service.wha;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface AdminService {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List queryAdminPager(Admin admin, PageBean pageBean);
}
