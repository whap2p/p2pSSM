package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.EmployeeMapper;
import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("whaEmployeeService")
public class WhaEmployeeServiceImpl implements WhaEmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List queryEmployeePager(Employee employee, PageBean pageBean) {
        return employeeMapper.queryEmployee(employee);
    }

    @Override
    public int insertSelective(Employee record) {
        return employeeMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer eid) {
        return employeeMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public Employee selectByPrimaryKey(Integer eid) {
        return employeeMapper.selectByPrimaryKey(eid);
    }

    @Override
    public int updateByPrimaryKeySelective(Employee record) {
        return employeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Employee selectByPrimaryKeyename(String ename) {
        return employeeMapper.selectByPrimaryKeyename(ename);
    }

    @Override
    public Set<String> queryRolesByEmpName(String userName) {
        return employeeMapper.queryRolesByEmpName(userName);
    }

    @Override
    public Set<String> queryPermssByEmpName(String userName) {
        return employeeMapper.queryPermssByEmpName(userName);
    }
}
