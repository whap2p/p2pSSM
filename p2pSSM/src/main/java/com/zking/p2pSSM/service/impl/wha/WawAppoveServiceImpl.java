package com.zking.p2pSSM.service.impl.wha;

import com.zking.p2pSSM.mapper.wha.ApproveitemMapper;
import com.zking.p2pSSM.mapper.wha.CertifrecordMapper;
import com.zking.p2pSSM.mapper.wha.UserauditorMapper;
import com.zking.p2pSSM.mapper.wha.clapplyforMapper;
import com.zking.p2pSSM.model.Approveitem;
import com.zking.p2pSSM.model.Certifrecord;
import com.zking.p2pSSM.model.Userauditor;
import com.zking.p2pSSM.service.wha.WhaAppoveService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WawAppoveServiceImpl implements WhaAppoveService {
    @Autowired
    CertifrecordMapper certifrecordMapper;
    @Autowired
    clapplyforMapper clapplyforMapper;
    @Autowired
    UserauditorMapper userauditorMapper;
    @Autowired
    ApproveitemMapper approveitemMapper;

    @Override
    public List queryCertifrecordPager(HashMap<String, Object> map, PageBean pageBean) {
        return certifrecordMapper.queryCertifrecord(map);
    }

    @Override
    public List queryClapplyforsPager(HashMap<String, Object> map, PageBean pageBean) {
        return clapplyforMapper.queryClapplyfors(map);
    }

    @Override
    public List queryUserauditor(HashMap<String, Object> map) {
        return userauditorMapper.queryUserauditor(map);
    }

    @Override
    public int addUserauditor(Userauditor userauditor) {
        return userauditorMapper.insertSelective(userauditor);
    }

    @Override
    public int updateCertifrecord(Certifrecord certifrecord) {
        return certifrecordMapper.updateByPrimaryKeySelective(certifrecord);
    }

    @Override
    public List queryApprovesPager(HashMap<String, Object> map, PageBean pageBean) {
        return approveitemMapper.queryApproves(map);
    }

    @Override
    public int updateByPrimaryKeySelective(Approveitem record) {
        return approveitemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Approveitem record) {
        return approveitemMapper.insertSelective(record);
    }
}
