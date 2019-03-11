package com.zking.p2pSSM.service.hhj;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.utils.PageBean;

import java.util.List;

/**
 * @author标题
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2019-03-08 16:25
 */
public interface IBiaoService {
    int deleteByPrimaryKey(Integer id);

    int insert(Biao record);

    int insertSelective(Biao record);

    Biao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Biao record);

    int updateByPrimaryKey(Biao record);

    List<Biao> ShowBiaoPager(PageBean pageBean);
}
