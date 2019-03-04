package com.zking.p2pSSM.mapper.wha;

import com.zking.p2pSSM.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List queryEmployee(Employee employee);

    Employee selectByPrimaryKeyename(String ename);

    /**
     * 通过唯一的账户名查询对应的角色ID集合
     * @param ename
     * @return
     */
    Set<String> queryRolesByEmpName(String ename);

    /**
     * 通过唯一的账户名查询对应的权限ID集合
     *
     * @param ename
     * @return
     */
    Set<String> queryPermssByEmpName(String ename);
}