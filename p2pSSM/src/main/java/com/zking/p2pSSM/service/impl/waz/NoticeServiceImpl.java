package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazNoticeMapper;
import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.service.waz.NoticeService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private WazNoticeMapper wazNoticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer noticeid) {
        return wazNoticeMapper.deleteByPrimaryKey(noticeid);
    }

    @Override
    public int insert(Notice record) {
        return wazNoticeMapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return wazNoticeMapper.insertSelective(record);
    }

    @Override
    public Notice selectByPrimaryKey(Integer noticeid) {
        return wazNoticeMapper.selectByPrimaryKey(noticeid);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return wazNoticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Notice> queryByIdPager(Notice notice, PageBean pageBean) {
        return wazNoticeMapper.queryById(notice);
    }

    @Override
    public List<Notice> queryByType(String noticetype) {
        return wazNoticeMapper.queryByType(noticetype);
    }

    @Override
    public List<Notice> queryByTop(String noticetype) {
        return wazNoticeMapper.queryByTop(noticetype);
    }


}
