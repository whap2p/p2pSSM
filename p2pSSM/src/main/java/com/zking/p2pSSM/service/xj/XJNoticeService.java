package com.zking.p2pSSM.service.xj;

import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

/**
 * @author @我只是健健吖
 * @create  2019-03-06 上午 8:37
 */
public interface XJNoticeService<list> {

    int deleteByPrimaryKey(Integer noticeid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    /**
     * 网站内容的查寻分页外加分类查寻
     * @return list
     */
    List<Notice> queryNoticePager(String noticetype, PageBean pageBean);

    /**
     * 查寻前台首页的图片以及网址
     * @return
     */
    List<Notice> queryimgPager(PageBean pageBean);

    List<Notice> queryoneNoticePager(String noticetype,PageBean PageBean);

}
