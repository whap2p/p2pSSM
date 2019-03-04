package com.zking.p2pSSM.service.wha;


import com.zking.p2pSSM.model.Borrowmoney;
import com.zking.p2pSSM.model.Poundage;
import com.zking.p2pSSM.model.Recharge;
import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.utils.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WithrawalService {
    /**
     * 根据条件查询单个
     * @param wID
     * @return
     */
    Withdrawal selectByPrimaryKey(Integer wID);
    /**
     * 根据条件修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Withdrawal record);
    /**
     * g根据条件分页查询
     * @param map
     * @param pageBean
     * @return
     */
    List queryWithdrawalPager(Map<String, Object> map, PageBean pageBean);

    /**
     * 提现总额
     * @return
     */
    int sumtxmoney();

    /**
     * 到账总额
     * @return
     */
    int sumdzmoney();

    /**
     * 手续费总额
     * @return
     */
    int sumsxf();

    /**
     * 修改（转账失败：退还certification表的用户的可用余额与总金额）
     * @param ma
     * @return
     */
    int updatedmoney(Map<String, Object> ma);

    /**
     * 增加（转账交易记录）
     * @param ma
     * @return
     */
    int inserttmoney(Map<String, Object> ma);

    /**
     * 查询交易记录-
     * @param pageBean
     * @return
     */
    List queryTradePager(Map<String, Object> map, PageBean pageBean);

    /**
     *查询借贷信息列表
     * @param borrowmoney
     * @param pageBean
     * @return
     */
    List queryBorrowmoneyPager(Borrowmoney borrowmoney, PageBean pageBean);

    /**
     *查询单个借贷信息
     * @param id
     * @return
     */
    Borrowmoney selectByPrimaryBorrowmoneyKey(Integer id);
    /**
     *查询手续费记录
     * @param pageBean
     * @return
     */
    List queryPoundagePager(HashMap<String, Object> map, PageBean pageBean);

    /**
     *查询单个手续费记录
     * @param id
     * @return
     */
    Poundage selectByPrimaryPoundageKey(Integer id);
    /**
     *查询充值记录
     * @param recharge
     * @param pageBean
     * @return
     */
    List queryRechargePager(HashMap<String, Object> map, PageBean pageBean);

    /**
     *查询单个充值记录
     * @param id
     * @return
     */
    Recharge selectByPrimaryRechargeKey(Integer id);

    /**
     * 查询用户银行卡管理
     * @param map
     * @return
     */
    List queryBankcardPager(HashMap<String, Object> map, PageBean pageBean);
}
