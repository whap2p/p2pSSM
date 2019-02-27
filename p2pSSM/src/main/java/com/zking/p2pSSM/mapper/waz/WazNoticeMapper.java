package com.zking.p2pSSM.mapper.waz;

import com.zking.p2pSSM.model.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WazNoticeMapper {
    int deleteByPrimaryKey(Integer noticeid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);


    /**
     * 公告查询
     * @param notice
     * @return
     */
    List<Notice> queryById(Notice notice);

    /**
     * 主页公告查询
     * @param noticetype
     * @return
     */
    List<Notice> queryByType(String noticetype);

    /**
     * 主页展示公告取最新5条
     * @param noticetype
     * @return
     */
    List<Notice> queryByTop(String noticetype);
}