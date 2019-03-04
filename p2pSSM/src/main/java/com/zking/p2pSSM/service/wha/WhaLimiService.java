package com.zking.p2pSSM.service.wha;

import com.zking.p2pSSM.model.Limi;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface WhaLimiService {
    /**
     *
     * @param eid
     * @return
     */
    int deleteByPrimaryKey(Integer did);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(Limi record);
    /**
     *
     * @param limi
     * @param pageBean
     * @return
     */
    List queryLimiPager(Limi limi, PageBean pageBean);
}
