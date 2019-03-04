package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Details;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface DetailsService {
    int deleteByPrimaryKey(Integer did);

    int insert(Details record);

    int insertSelective(Details record);

    Details selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Details record);

    int updateByPrimaryKey(Details record);

    /**
     *
     * @param details
     * @return
     */
    List<Details> queryPager(Details details, PageBean pageBean);
}