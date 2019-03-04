package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.*;
import com.zking.p2pSSM.service.wha.WithrawalService;
import com.zking.p2pSSM.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 查询提现用户
     * @param request
     * @param btn
     * @param wname
     * @param yyy
     * @param yyyy
     * @param wstatu
     * @return
     */
    @RequiresUser
    @RequestMapping("wlist")
    public String withdrawallist(HttpServletRequest request,@RequestParam(value = "btn", required = false) String btn,
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
    /**
     *转账成功或失败
     */
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
            map1.put("i", i);
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
            map2.put("wone", wone);
            map2.put("i", i);
            withrawalService.inserttmoney(map2);
        }
        return "redirect:wlist";
    }

    /**
     *审核通过
     * @param gg
     * @param wid
     * @param req
     * @return
     */
    @RequestMapping("shen")
    public String shen(@RequestParam(value = "gg", required = false) int gg,
                       @RequestParam(value = "wid", required = false) int wid,HttpServletRequest req){
        HttpSession session = req.getSession();
        Employee emp = (Employee) session.getAttribute("globalemp");
        String shname = emp.getEname();
        if(gg==0){
            //失败：需要改成失败，并且修改转账时间，审核人时间，审核人
            //成功：需要改成转账中，并且修改转账时间，审核人时间，审核人
            Withdrawal w=new Withdrawal();
            w.setStatu(String.valueOf(gg));
            w.setwID(wid);
            w.setShwho(shname);
            w.setZztime(new Date());
            w.setShtime(new Date());
            withrawalService.updateByPrimaryKeySelective(w);
            //退钱
            Withdrawal wone =  withrawalService.selectByPrimaryKey(wid);
            Integer txmoney = Integer.parseInt(wone.getTxmoney());//体检金额
            Integer uid = wone.getuID();//用户id
            //修改:退还certification表的用户的可用余额与总金额
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("txmoney", Integer.parseInt(wone.getTxmoney()));//提现金额
            map.put("uid", uid);
            withrawalService.updatedmoney(map);
            int i=0;
            //添加失败的交易记录
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("wone", wone);
            map2.put("i", i);
            withrawalService.inserttmoney(map2);
        }else if(gg==2){
            //成功：需要改成转账中，并且修改转账时间，审核人时间，审核人
            Withdrawal w2=new Withdrawal();
            w2.setStatu(String.valueOf(gg));
            w2.setwID(wid);
            w2.setShwho(shname);
            w2.setZztime(new Date());
            w2.setShtime(new Date());
            withrawalService.updateByPrimaryKeySelective(w2);
        }
        return "redirect:wlist";
    }
    @RequestMapping("withdrawallist")
    @ResponseBody
    public Withdrawal withdrawallist(@RequestParam(value = "id", required = false) int id){
        return withrawalService.selectByPrimaryKey(id);
    }
    /**
     * 交易记录
     * @param request
     * @return
     */
    @RequestMapping("trade")
    public String bankcardtrade(HttpServletRequest request,
                                @RequestParam(value = "zname", required = false) String zname,
                                @RequestParam(value = "uname", required = false) String uname,
                                @RequestParam(value = "yyy", required = false) String yyy,
                                @RequestParam(value = "yyyy", required = false) String yyyy){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
       HashMap<String,Object> map=new HashMap<String, Object>();
       map.put("zname",zname);
        map.put("uname",uname);
        map.put("yyy",yyy);
        map.put("yyyy",yyyy);
        List list=withrawalService.queryTradePager(map,pageBean);
        request.setAttribute("lts",list);
        request.setAttribute("pageBean",pageBean);
        return str + "Tradelist";
    }

    @RequestMapping("hjyList")
    public String hjyList(HttpServletRequest request, @RequestParam(value = "currpage", required = false) String currpage) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List list=withrawalService.queryBorrowmoneyPager(null,pageBean);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("wdlist", list);
        return str + "Borrowmoneylist";
    }

    @RequestMapping("Borrowmoneylist")
    @ResponseBody
    public Borrowmoney Borrowmoneylist(@RequestParam(value = "id", required = false) int id){
        return withrawalService.selectByPrimaryBorrowmoneyKey(id);
    }
    /**
     * 充值记录
     * @return
     */
    @RequestMapping("rech")
    public String rech(HttpServletRequest request,
                       @RequestParam(value = "statu", required = false) String statu,
                       @RequestParam(value = "zflx", required = false) String zflx,
                       @RequestParam(value = "uname", required = false) String uname,
                       @RequestParam(value = "yyy", required = false) String yyy,
                       @RequestParam(value = "yyyy", required = false) String yyyy){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("statu",statu);
        map.put("zflx",zflx);
        map.put("uname",uname);
        map.put("yyy",yyy);
        map.put("yyyy",yyyy);
        List list=withrawalService.queryRechargePager(map,pageBean);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("lrc", list);
        return str + "Rechargelist";
    }
    /**
     * 手续费记录
     * @return
     */
    @RequestMapping("poundage")
    public String bankcardpoundage(HttpServletRequest request,
                                   @RequestParam(value = "zname", required = false) String zname,
                                   @RequestParam(value = "uname", required = false) String uname,
                                   @RequestParam(value = "yyy", required = false) String yyy,
                                   @RequestParam(value = "yyyy", required = false) String yyyy){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("zname",zname);
        map.put("uname",uname);
        map.put("yyy",yyy);
        map.put("yyyy",yyyy);
        List list=withrawalService.queryPoundagePager(map,pageBean);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("lpa", list);
        return str + "Poundagelist";
    }

    /**
     *  用户银行卡管理
     * @return
     */
    @RequestMapping("bankcard")
    public String bankcard(HttpServletRequest request
            ,@RequestParam(value = "uname", required = false) String uname
            ,@RequestParam(value = "zname", required = false) String zname
            ,@RequestParam(value = "yyy", required = false) String yyy
            ,@RequestParam(value = "yyyy", required = false) String yyyy){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("uname", uname);
        map.put("yyy", yyy);
        map.put("yyyy", yyyy);
        map.put("zname", zname);
        List list=withrawalService.queryBankcardPager(map,pageBean);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("bc", list);
        return str + "BankCardllist";
    }
}
