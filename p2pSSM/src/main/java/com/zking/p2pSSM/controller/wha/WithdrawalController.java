package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.service.wha.DeptService;
import com.zking.p2pSSM.service.wha.WithrawalService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wd/")
public class WithdrawalController {
    final String str = "WEB-INF/view/";
    @Autowired
    WithrawalService withrawalService;
    @RequestMapping("wlist")
    public String withdrawallist(HttpServletRequest request,@RequestParam(value = "currpage", required = false) String currpage,
                                 @RequestParam(value = "btn", required = false) String btn,
                                 @RequestParam(value = "wname", required = false) String wname,
                                 @RequestParam(value = "yyy", required = false) String yyy,
                                 @RequestParam(value = "yyyy", required = false) String yyyy,
                                 @RequestParam(value = "wstatu", required = false) String wstatu){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HttpSession session = request.getSession();
        session.setAttribute("btn", btn);
        Map<String, Object> findmap = new HashMap<String, Object>();
//        第一次过滤：根据状态（失败，已提现,转账中，审核中）查询
        findmap.put("btn", btn);
//        第二次过滤：用户名、提交时间、根据状态（失败，已提现,转账中，审核中）查询
        findmap.put("wname", wname);
        findmap.put("yyy", yyy);
        findmap.put("yyyy", yyyy);
        findmap.put("wstatu", wstatu);
        session.setAttribute("wname", wname);
        session.setAttribute("yyy", yyy);
        session.setAttribute("yyyy", yyyy);
        session.setAttribute("wstatu", wstatu);
        List list=withrawalService.queryWithdrawalPager(findmap,pageBean);
        System.out.println("list:"+list.size()+list.toString());
        //查询后返回的数据
        request.setAttribute("wdlist",list);
       //分页
        request.setAttribute("pageBean",pageBean);
        //提现总额
        request.setAttribute("suntxmoney",withrawalService.sumtxmoney());
        //到账总额
        request.setAttribute("sumdzmoney",withrawalService.sumdzmoney());
        //手续费总额
        request.setAttribute("sumsxf",withrawalService.sumsxf());
        return str + "Withdrawallist";
    }
    //转账成功或失败
    @RequestMapping("zhuans")
    public String zhuan(@RequestParam(value = "gg", required = false) int gg,
                        @RequestParam(value = "wid", required = false) int wid){
        Withdrawal wone =  withrawalService.selectByPrimaryKey(wid);
        if(gg==0){//转账失败
            Withdrawal w=new Withdrawal();
            w.setwID(wone.getwID());
            w.setStatu(String.valueOf(gg));
            withrawalService.updateByPrimaryKeySelective(w);//修改:withdrawal表的状态失败0
            //退钱
            Integer uid = wone.getuID();//用户id
            //修改:退还certification表的用户的可用余额与总金额
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("txmoney", Integer.parseInt(wone.getTxmoney()));//提现金额
            map.put("uid", uid);
            withrawalService.updatedmoney(map);
            int i=1;
            //添加失败的交易记录
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("wone", wone);
            map1.put("i", uid);
            withrawalService.inserttmoney(map1);
        }else if(gg==1){//转账成功已提现
            //成功
            Withdrawal w1=new Withdrawal();
            w1.setwID(wone.getwID());
            w1.setStatu(String.valueOf(gg));
            withrawalService.updateByPrimaryKeySelective(w1);//修改withdrawal表的状态已提现1
            int i=2;
            //添加交易成功记录
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("wone", wid);
            map2.put("i", i);
            withrawalService.inserttmoney(map2);
        }
        return "redirect:wlist";
    }
    //审核通过
    @RequestMapping("shen")
    public String shen(@RequestParam(value = "gg", required = false) int gg,
                       @RequestParam(value = "wid", required = false) int wid,HttpServletRequest req){
//        HttpSession session = req.getSession();
//        Employee emp = (Employee) session.getAttribute("globalemp");
//        String shname = emp.getEname();
//        if(gg==0){
//            //失败 需要改成失败  并且修改转账时间，审核人时间，审核人
//            withrawalService.updwiths(gg, wid, shname);
//            //退钱
//            Withdrawal wone =  ws.selectone(wid);
//            Integer txmoney = Integer.parseInt(wone.getTxmoney());//体检金额
//            Integer uid = wone.getuID();//用户id
//            withrawalService.updmoney(txmoney, uid);
//            int i=0;
//            //添加失败的交易记录
//            withrawalService.intmoney(wone, i);
//        }else if(gg==2){
//            //成功    需要改成转账中  并且修改转账时间，审核人时间，审核人
//
//            withrawalService.updwiths(gg, wid, shname);
//
//        }
        return "redirect:wlist";
    }


}
