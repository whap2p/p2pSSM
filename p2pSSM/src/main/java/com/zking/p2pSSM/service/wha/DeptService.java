package com.zking.p2pSSM.service.wha;

import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DeptService {
    int deleteByPrimaryKey(Integer did);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List queryDeptPager(Dept dept,PageBean pageBean);
}
