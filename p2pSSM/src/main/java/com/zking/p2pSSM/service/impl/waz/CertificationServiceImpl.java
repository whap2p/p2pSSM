package com.zking.p2pSSM.service.impl.waz;

import com.zking.p2pSSM.mapper.waz.WazCertificationMapper;
import com.zking.p2pSSM.model.Certification;
import com.zking.p2pSSM.service.waz.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    private WazCertificationMapper wazCertificationMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Certification record) {
        return 0;
    }

    @Override
    public int insertSelective(Certification record) {
        return 0;
    }

    @Override
    public Certification selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Certification record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Certification record) {
        return 0;
    }

    @Override
    public int updateByCbalance(Certification certification) {
        return wazCertificationMapper.updateByCbalance(certification);
    }

    @Override
    public Certification queryByCusername(String cusername) {
        return wazCertificationMapper.queryByCusername(cusername);
    }
}
