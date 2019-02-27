package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

public interface NoticeService {
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
    List<Notice> queryByIdPager(Notice notice, PageBean pageBean);

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