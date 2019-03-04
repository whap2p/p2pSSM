package com.zking.p2pSSM.service.wha;


import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;
import java.util.Set;

public interface WhaEmployeeService {
    /**
     * 分页模糊查询
     * @param employee
     * @param pageBean
     * @return
     */
    List queryEmployeePager(Employee employee, PageBean pageBean);

    /**
     * 增加员工
     * @param record
     * @return
     */
    int insertSelective(Employee record);

    /**
     * 删除
     * @param eid
     * @return
     */
    int deleteByPrimaryKey(Integer eid);

    /**
     * 查询单个
     * @param eid
     * @return
     */
    Employee selectByPrimaryKey(Integer eid);

    /**
     * 根据条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * 根据员工姓名查询（登录）
     * @param ename
     * @return
     */
    Employee selectByPrimaryKeyename(String ename);

    Set<String> queryRolesByEmpName(String userName);

    Set<String> queryPermssByEmpName(String userName);
}
