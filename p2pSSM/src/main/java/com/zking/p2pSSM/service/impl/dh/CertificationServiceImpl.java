package com.zking.p2pSSM.service.impl.dh;

import com.zking.p2pSSM.mapper.dh.CertificationMapper;
import com.zking.p2pSSM.model.dh.Certification;
import com.zking.p2pSSM.service.dh.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 19:11
 */
@Service
public class CertificationServiceImpl implements CertificationService {
    @Autowired
    private CertificationMapper certificationMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return certificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Certification record) {
        return certificationMapper.insertSelective(record);
    }

    @Override
    public Certification selectByPrimaryKey(Integer id) {
        return certificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Certification record) {
        return 0;
    }

    @Override
    public Certification queryByCusername(String cusername) {
        return certificationMapper.queryByCusername(cusername);
    }
}
