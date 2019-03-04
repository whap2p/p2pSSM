package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.DeptMapper;
import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.service.wha.DeptService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer did) {
        return deptMapper.deleteByPrimaryKey(did);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Integer did) {
        return deptMapper.selectByPrimaryKey(did);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List queryDeptPager(Dept dept, PageBean pageBean) {
        return deptMapper.queryDept(dept);
    }
}
