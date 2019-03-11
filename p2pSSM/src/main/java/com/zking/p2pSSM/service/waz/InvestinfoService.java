package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Investinfo;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface InvestinfoService {
    int deleteByPrimaryKey(Integer inid);

    int insert(Investinfo record);

    int insertSelective(Investinfo record);

    Investinfo selectByPrimaryKey(Integer inid);

    int updateByPrimaryKeySelective(Investinfo record);

    int updateByPrimaryKey(Investinfo record);

    /**
     * 投资表查询
     * @param investinfo
     * @return
     */
    List<Investinfo> queryPager(Investinfo investinfo, PageBean pageBean);

    /**
     * 通过投标id目前投标总额
     * @param investinfo
     * @return
     */
    int sumBYInmoney(Investinfo investinfo);

    /**
     * 通过投标id目前收益总额
     * @param investinfo
     * @return
     */
    int sumBYProfitmoney(Investinfo investinfo);
}