package com.zking.p2pSSM.controller.dh;

import com.zking.p2pSSM.model.*;
import com.zking.p2pSSM.service.dh.*;
import com.zking.p2pSSM.utils.PageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        UsernamePasswordToken token = new UsernamePasswordToken(users.getUnickname(),users.getUpassword());
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(token);
            Users users1 = usersService.qureyByName(users);
            if(users1 != null){
                request.getSession().setAttribute("globaluser",users1);
                return "forward:/index.jsp";
            }else{
                return "redirect:/login.jsp";
            }
//        }catch (Exception e){
//            return "redirect:/login.jsp";
//        }
    }

    @RequestMapping("/exit")
    public String exit(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
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
        if(i>0){
            request.setAttribute("unickname",users.getUnickname());
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
//        Investstat investstat = investstatService.queryByuserid(id);
        Certification certification = certificationService.queryByCusername(users.getUnickname());
        request.getSession().setAttribute("globaluser",users);
        request.getSession().setAttribute("certification",certification);
        return "personalpage";
    }

    @RequestMapping("/kaihu")
    @Transactional
    public String kaihu(Users user){
        Bankcard bankcard = dhBankcardService.qureyBysfz(user.getUcardid());
        user.setUserpaytoid(bankcard.getCardid());
        int i = usersService.updateByPrimaryKeySelective(user);
        if(i>0){
            return "/user/query?id="+user.getUid();
        }else {
            return "redirect:/thirdparty.jsp";
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


    public String qureyTrade(int uid){
        Map map = new HashMap();
        map.put("uid",uid);
        List<Trade> list = dhTradeService.queryTrade(map);

        return "";
    }



}
