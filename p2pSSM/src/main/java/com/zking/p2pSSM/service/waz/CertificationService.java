package com.zking.p2pSSM.service.waz;

import com.zking.p2pSSM.model.Certification;
import org.springframework.stereotype.Repository;

public interface CertificationService {
    int deleteByPrimaryKey(Integer id);

    int insert(Certification record);

    int insertSelective(Certification record);

    Certification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Certification record);

    int updateByPrimaryKey(Certification record);

    int updateByCbalance(Certification certification);

    Certification queryByCusername(String cusername);

}