package com.zking.p2pSSM.controller.dh;

import com.zking.p2pSSM.model.dh.*;
import com.zking.p2pSSM.service.dh.BankcardService;
import com.zking.p2pSSM.service.dh.CertificationService;
import com.zking.p2pSSM.service.dh.InveststatService;
import com.zking.p2pSSM.service.dh.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author段豪
 * @site www.zking.com
 * @company xxx公司
 * @create  2019-02-26 10:24
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private InveststatService investstatService;
    @Autowired
    private CertificationService certificationService;
    @Autowired
    private BankcardService bankcardService;


    @RequestMapping("/login")
    public String login(Users users, HttpServletRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUnickname(),users.getUpassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            Users users1 = usersService.qureyByName(users.getUnickname());
            subject.login(token);
            request.getSession().setAttribute("globaluser",users1);
            return "forward:/index.jsp";
        }catch (Exception e){
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/toUrl")
    public String getUrl(String url,String type){
        return type+":/"+url;
    }

    @RequestMapping("/insert")
    public  String insert(Users users) throws ParseException {
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
            return "forward:/register1.jsp";
    }else{
            return "redirect:/register.jsp";
        }
    }

    @ResponseBody
    @RequestMapping("/findByName")
    public Users findByName(Users users){
        Users users1 = usersService.qureyByName(users.getUnickname());
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
        System.out.println(user.getUid());
        System.out.println("进入方法！");
        Bankcard bankcard = bankcardService.qureyBysfz(user.getUcardid());
        user.setUserpaytoid(bankcard.getCardid());
        int i = usersService.updateByPrimaryKeySelective(user);
        if(i>0){
            return "/user/query?id="+user.getUid();
        }else {
            return "redirect:/thirdparty.jsp";
        }
    }

}
