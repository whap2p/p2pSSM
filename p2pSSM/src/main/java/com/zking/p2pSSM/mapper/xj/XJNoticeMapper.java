package com.zking.p2pSSM.mapper.xj;

import com.zking.p2pSSM.model.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XJNoticeMapper {
    int deleteByPrimaryKey(Integer noticeid);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeid);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    /**
     * 网站内容的查寻分页外加分类查寻
     * @param noticetype
     * @return list
     */
    List<Notice> queryNoticePager(String noticetype);

    List<Notice> queryoneNoticePager(String noticetype);

    /**
     * 查寻前台首页的图片以及网址
     * @return
     */
    List<Notice> queryimgPager();

}