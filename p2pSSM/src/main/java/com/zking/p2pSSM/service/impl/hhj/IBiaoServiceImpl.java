package com.zking.p2pSSM.service.impl.hhj;

import com.zking.p2pSSM.mapper.hhj.HhjBiaoMapper;
import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.service.hhj.IBiaoService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author标题
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2019-03-08 16:26
 */
@Service
public class IBiaoServiceImpl implements IBiaoService {
    @Autowired
    HhjBiaoMapper hhjBiaoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return hhjBiaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Biao record) {
        return hhjBiaoMapper.insert(record);
    }

    @Override
    public int insertSelective(Biao record) {
        return hhjBiaoMapper.insertSelective(record);
    }

    @Override
    public Biao selectByPrimaryKey(Integer id) {
        return hhjBiaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Biao record) {
        return hhjBiaoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Biao record) {
        return hhjBiaoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Biao> ShowBiaoPager(PageBean pageBean) {
        return hhjBiaoMapper.ShowBiaoPager();
    }
}
