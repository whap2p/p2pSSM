package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}