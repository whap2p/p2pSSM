package com.zking.p2pSSM.service.wha;

import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DeptService {
    /**
     * 根据条件删除
     * @param did
     * @return
     */
    int deleteByPrimaryKey(Integer did);
    /**
     * 根据条件增加
     * @param record
     * @return
     */
    int insertSelective(Dept record);

    /**
     * 查询单个
     * @param did
     * @return
     */
    Dept selectByPrimaryKey(Integer did);
    /**
     * 根据条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dept record);
    /**
     * 分页查询
     * @param dept
     * @param pageBean
     * @return
     */
    List queryDeptPager(Dept dept, PageBean pageBean);
}
