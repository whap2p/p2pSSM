package com.zking.p2pSSM.service.dh;

import com.zking.p2pSSM.model.Certification;

public interface DhCertificationService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Certification record);

    Certification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Certification record);

    Certification queryByCusername(String cusername);

}