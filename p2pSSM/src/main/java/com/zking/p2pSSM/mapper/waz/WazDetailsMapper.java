package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Details;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WazDetailsMapper {
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
    List<Details> query(Details details);
}