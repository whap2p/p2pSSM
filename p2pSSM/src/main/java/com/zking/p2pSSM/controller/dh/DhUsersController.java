package com.zking.p2pSSM.controller.dh;

import com.zking.p2pSSM.model.*;
import com.zking.p2pSSM.service.dh.*;
import com.zking.p2pSSM.utils.PageBean;
import com.zking.p2pSSM.utils.RandomCreditCardNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 10:24
 */
@Controller
@RequestMapping("/user")
public class DhUsersController {
    @Autowired
    private DhUsersService usersService;
    @Autowired
    private DhInveststatService investstatService;
    @Autowired
    private DhCertificationService certificationService;
    @Autowired
    private DhBankcardService dhBankcardService;
    @Autowired
    private DhWithdrawalService withdrawalService;
    @Autowired
    private DhRechargeService dhRechargeService;
    @Autowired
    private DhDopeServiec dhDopeServiec;
    @Autowired
    private DhInvestinfoService dhInvestinfoService;
    @Autowired
    private DhBiaoService dhBiaoService;
    @Autowired
    private DhTradeService dhTradeService;



    @RequestMapping("/login")
    public String login(Users users, HttpServletRequest request){
            Users users1 = usersService.qureyByName(users);
            if(users1 != null){
                request.getSession().setAttribute("globaluser",users1);
                return "forward:/index.jsp";
            }else{
                return "redirect:/login.jsp";
            }
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().setMaxInactiveInterval(1);
        return "redirect:/login.jsp";
    }


    @RequestMapping("/toUrl")
    public String getUrl(String url,String type){
        return type+":/"+url;
    }

    @RequestMapping("/insert")
    public  String insert(Users users, HttpServletRequest request) throws ParseException {
        users.setUid(usersService.getId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(df.format(new Date()));
        users.setUregisterdate(date);
        int i = usersService.insertSelective(users);
        Certification certification = new Certification();
        certification.setCserial(users.getUid().toString());
        certification.setCusername(users.getUnickname());
        certification.setCrealname(users.getUname());
        certificationService.insertSelective(certification);
        Users users1 = usersService.qureyByName(users);
        if(i>0){
            request.getSession().setAttribute("globaluser",users1);
            return "forward:/register1.jsp";
        }else{
            return "redirect:/register.jsp";
        }
    }


    @ResponseBody
    @RequestMapping("/findByName")
    public Users findByName(Users users){
        Users users1 = usersService.qureyByName(users);
        return users1;
    }

    @RequestMapping("/query")
    public String findByID(int id,HttpServletRequest request){
        Users users = usersService.selectByPrimaryKey(id);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Trade> list = dhTradeService.queryTrade(id);
        List<Biao> dhBiaos = dhBiaoService.queryBiao();
        List<Investinfo> dhInvestinfos = dhInvestinfoService.qureyInvestinfoPager(id,pageBean);
//        Investstat investstat = investstatService.queryByuserid(id);
        Certification certification = certificationService.queryByCusername(users.getUnickname());
        request.getSession().setAttribute("globaluser",users);
        request.getSession().setAttribute("certification",certification);
        request.getSession().setAttribute("record",dhInvestinfos);
        request.getSession().setAttribute("biao",dhBiaos);
        request.getSession().setAttribute("trades",list);
        return "personalpage";
    }

    @RequestMapping("/kaihu")
    @Transactional
    public String kaihu(Users user,String bkname) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(df.format(new Date()));
        String cardid = RandomCreditCardNumberGenerator.get_Bank_account();
        Bankcard bankcard = new Bankcard();
        bankcard.setuID(user.getUid());
        bankcard.setUname(user.getUnickname());
        bankcard.setZname(user.getUname());
        bankcard.setSfz(user.getUcardid());
        bankcard.setKhh(bkname);
        bankcard.setCardid(cardid);
        bankcard.setTjtime(date);
        bankcard.setStatu("成功");
        dhBankcardService.insertSelective(bankcard);
        Bankcard bankcard1 = dhBankcardService.qureyBysfz(user.getUcardid());
        user.setUserpaytoid(bankcard1.getCardid());
        int i = usersService.updateByPrimaryKeySelective(user);
        if(i>0){
            Inactiveuser inactiveuser = new Inactiveuser();
            inactiveuser.setIuname(user.getUnickname());
            inactiveuser.setIdmailbox(user.getUmailbox());
            inactiveuser.setiCreatetime(date);
            return "/user/query?id="+user.getUid();
        }else {
            return "thirdparty";
        }
    }

    @RequestMapping("/tixian")
    @Transactional
    public String tixian(int uid,String txmoney) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(df.format(new Date()));
        double txmoneys=Double.parseDouble(txmoney);
        double dx = txmoneys - txmoneys*0.001;
        double sxf = txmoneys*0.001;

        Users users = usersService.selectByPrimaryKey(uid);
        Bankcard bankcard = dhBankcardService.qureyBysfz(users.getUcardid());
        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setuID(users.getUid());
        withdrawal.setUname(users.getUnickname());
        withdrawal.setZname(users.getUname());
        withdrawal.setTxnum(bankcard.getCardid());
        withdrawal.setTxbank(bankcard.getKhh());
        withdrawal.setTxmoney(txmoney);
        withdrawal.setDzmoney(String.valueOf(dx));
        withdrawal.setSxf(String.valueOf(sxf));
        withdrawal.setTxtime(date);
        withdrawal.setStatu("审核中");
        int i = withdrawalService.insertSelective(withdrawal);
        if(i>0) {
            Certification certification = certificationService.queryByCusername(users.getUnickname());
            String cbalance = certification.getCbalance();
            double cbalances = Double.parseDouble(cbalance);
            double kyye = cbalances - txmoneys;
            certification.setCbalance(String.valueOf(kyye));
            certificationService.updateByPrimaryKeySelective(certification);
            Dope dhDope = new Dope();
            dhDope.setDprimkey(users.getUid());
            dhDope.setDtitle("提现审核中");
            dhDope.setDetails("尊敬的用户,您的提现金额"+txmoney+"元正在审核中!");
            dhDope.setDtime(date);
            dhDopeServiec.insertSelective(dhDope);
            return "txsuccess";
        }else{
            return "txfail";
        }
    }

    @RequestMapping("/chongzhi")
    @Transactional
    public String chongzhi(int uid,Recharge dhRecharge) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(df.format(new Date()));
        Users users = usersService.selectByPrimaryKey(uid);
        dhRecharge.setuID(uid);
        dhRecharge.setUname(users.getUnickname());
        dhRecharge.setCzlx("银行卡充值");
        dhRecharge.setFl("0");
        dhRecharge.setDzmoney(dhRecharge.getCzmoney());
        dhRecharge.setCztime(date);
        Certification certification = certificationService.queryByCusername(users.getUnickname());
        String cbalance = certification.getCbalance();
        double cbalances = Double.parseDouble(cbalance);
        double czmoneys = Double.parseDouble(dhRecharge.getCzmoney());
        double kyye = cbalances + czmoneys;
        certification.setCbalance(String.valueOf(kyye));
        dhRecharge.setStatu("成功");
        dhRecharge.setZname(users.getUname());
        certificationService.updateByPrimaryKeySelective(certification);
        Dope dhDope = new Dope();
        dhDope.setDprimkey(users.getUid());
        dhDope.setDtitle("充值成功");
        dhDope.setDetails("尊敬的用户,您通过快捷支付充值的"+dhRecharge.getCzmoney()+"元已到账!");
        dhDope.setDtime(date);
        dhDopeServiec.insertSelective(dhDope);
        return "czsuccess";
    }

    @RequestMapping("/queryDope")
    public String queryDope(int id,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Dope> dhDopes = dhDopeServiec.qureyDopePager(id,pageBean);
        System.out.println(dhDopes.size());
        System.out.println(pageBean.getPage());
        request.getSession().setAttribute("totalPage",pageBean.getTotal());
        request.getSession().setAttribute("currpage",pageBean.getPage());
        request.getSession().setAttribute("dhDopes",dhDopes);
        return "forward:/messages.jsp";
    }


    @RequestMapping("/batchDeletes")
    public String delDope(int chkSon){
        dhDopeServiec.deleteByPrimaryKey(chkSon);
        return "redirect:/user/queryDope";
    }

    @RequestMapping("/qureyInvestinfo")
    public String qureyInvestinfo(int id,HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Biao> dhBiaos = dhBiaoService.queryBiao();
        List<Investinfo> dhInvestinfos = dhInvestinfoService.qureyInvestinfoPager(id,pageBean);
        request.getSession().setAttribute("totalPage",pageBean.getTotal());
        request.getSession().setAttribute("currpages",pageBean.getPage());
        request.getSession().setAttribute("record",dhInvestinfos);
        request.getSession().setAttribute("biao",dhBiaos);
        return "investrecord";
    }

    @RequestMapping("/queryTrade")
    public String qureyTrade(int uid,HttpServletRequest request){
//        List<Trade> list = dhTradeService.queryTrade(uid);
//        request.getSession().setAttribute("trades",list);
        return "forward:moneyrecord.jsp";
    }



}
