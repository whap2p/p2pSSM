package com.zking.p2pSSM.service.wha;

import com.zking.p2pSSM.model.Approveitem;
import com.zking.p2pSSM.model.Certifrecord;
import com.zking.p2pSSM.model.Userauditor;
import com.zking.p2pSSM.utils.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WhaAppoveService {

    List queryCertifrecordPager(HashMap<String,Object> map, PageBean pageBean);

    List queryClapplyforsPager(HashMap<String,Object> map,PageBean pageBean);

    List queryUserauditor(HashMap<String, Object> map);

    int addUserauditor(Userauditor userauditor);

    int updateCertifrecord(Certifrecord certifrecord);

    List queryApprovesPager(HashMap<String,Object> map,PageBean pageBean);

    int updateByPrimaryKeySelective(Approveitem record);

    int insertSelective(Approveitem record);
}
