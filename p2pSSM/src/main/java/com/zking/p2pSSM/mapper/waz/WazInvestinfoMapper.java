package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Investinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WazInvestinfoMapper {
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
    List<Investinfo> query(Investinfo investinfo);

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