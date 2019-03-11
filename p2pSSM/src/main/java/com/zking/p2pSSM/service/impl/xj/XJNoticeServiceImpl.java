package com.zking.p2pSSM.service.impl.xj;

import com.zking.p2pSSM.mapper.xj.XJNoticeMapper;
import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.service.xj.XJNoticeService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @我只是健健吖
 * @create  2019-03-06 上午 8:36
 */
@Service
public class XJNoticeServiceImpl implements XJNoticeService {
    @Autowired
    XJNoticeMapper xjNoticeMapper;
    @Override
    public int deleteByPrimaryKey(Integer noticeid) {
        return xjNoticeMapper.deleteByPrimaryKey(noticeid);
    }

    @Override
    public int insert(Notice record) {
        return xjNoticeMapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return xjNoticeMapper.insertSelective(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer noticeid) {
        return xjNoticeMapper.selectByPrimaryKey(noticeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return xjNoticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return xjNoticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Notice> queryNoticePager(String noticetype, PageBean pageBean) {
        return xjNoticeMapper.queryNoticePager(noticetype);
    }

    @Override
    public List<Notice> queryimgPager(PageBean pageBean) {
        return xjNoticeMapper.queryimgPager();
    }

    @Override
    public List<Notice> queryoneNoticePager(String noticetype, PageBean PageBean) {
        return xjNoticeMapper.queryoneNoticePager(noticetype);
    }

}
