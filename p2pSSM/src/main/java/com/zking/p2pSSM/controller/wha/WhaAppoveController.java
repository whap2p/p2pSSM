package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.*;
import com.zking.p2pSSM.service.wha.WhaAppoveService;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import com.zking.p2pSSM.service.wha.WhaUsersService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("approve/")
public class WhaAppoveController {
    final String str = "WEB-INF/view/";
    @Autowired
    WhaAppoveService whaAppoveService;
    //用户管理
    @Autowired
    WhaUsersService usersService;
    //员工管理
    @Autowired
    WhaEmployeeService whaEmployeeService;
    //信用额度申请
    @RequestMapping("limitApplyforlist")
    private String limitApplyfor(HttpServletRequest request,
                                 @RequestParam(value = "clpuname", required = false) String clpuname,
                                 @RequestParam(value = "mindate", required = false) String mindate,
                                 @RequestParam(value = "maxdate", required = false) String maxdate,
                                 @RequestParam(value = "clpstate", required = false) String clpstate) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HashMap<String, Object> pm = new HashMap<String, Object>();
        pm.put("clpuname",clpuname);
        pm.put("maxdate",maxdate);
        pm.put("mindate",mindate);
        pm.put("clpstate",clpstate);
        //查询用户信用额申请
        List<clapplyfor> clapplyfors =  whaAppoveService.queryClapplyforsPager(pm,null);
        //查询用户认证、审核记录
        List<Certifrecord> certifrecords = whaAppoveService.queryCertifrecordPager(null,pageBean);
        request.setAttribute("cr",certifrecords);
        request.setAttribute("cps", clapplyfors);
        request.setAttribute("clpuname", clpuname);
        request.setAttribute("mindate", mindate);
        request.setAttribute("clpstate", clpstate);
        request.setAttribute("pageBean",pageBean);
        return str + "limitapplyforlist";
    }

    //新用户认证资料
    @RequestMapping("anewuserInfoList")
    private String newuserInfoList(HttpServletRequest request) {
        //查询所有用户
        List<Users> users = usersService.queryUsersPager(null,null);
        Employee em=new Employee();
        em.setEstatus(1);
        //查询所有未离职员工表
        List<Employee> employees = whaEmployeeService.queryEmployeePager(em,null);
        //查询出所有用户审核表
        List<Userauditor> userauditors = whaAppoveService.queryUserauditor(null);
        //查询出所有用户的认证记录表
        List<Certifrecord> certifrecords = whaAppoveService.queryCertifrecordPager(null,null);
        if(userauditors!=null){//用户审核表不为空
            for (Userauditor userauditor : userauditors) {//循环用户审核表
                for(Users u : users){//循环用户表
                    //如果用户id == 用户审核表的用户id，该用户已审核，就剔除掉
                    if(userauditor.getUserid()==u.getUid()){
                        users.remove(u);
                        break;
                    }
                }
            }
        }
        //查询出未分配审核人1的积分，和待审核条数
        List<Certifrecord> cr = null;
        if(certifrecords!=null){
            cr =  new ArrayList<Certifrecord>();
            for (Users u : users) {//循环未分配的用户表数据
                Certifrecord cerrecord = new Certifrecord();
                int integral = 0;
                int ispass = 0;
                for (Certifrecord c : certifrecords) {//循环认证记录表
                    //如果用户id == 用户认证记录表的用户id
                    if(u.getUid()==c.getCruserid()){
                        if(c.getCrintegral()!=null){//信用积分不为空
                            integral+=c.getCrintegral();//信用积分循环加
                        }else{
                            integral+=0;
                        }
                        if(c.getCrispass().equals("1")){//待审核==1
                            ispass+=1;//待审核资料+1
                        }
                    }
                }
                cerrecord.setCruserid(u.getUid());//用户id
                cerrecord.setCrusername(u.getUnickname());//用户姓名
                cerrecord.setCrintegral(integral);//信用积分
                cerrecord.setCheckpend(ispass);//待审核
                cr.add(cerrecord);
            }
        }
        request.setAttribute("cr",cr);
        request.setAttribute("users",users);
        request.setAttribute("employees",employees);
        return str + "anewuserinfolist";
    }

    /**
     * 确定审核人员
     * @param ua
     * @return
     */
    @RequestMapping("affirmCrauditor")
    @ResponseBody
    public String affirmCrauditor(Userauditor ua){
        String code="200";
        Userauditor parameters =new Userauditor();
        parameters.setUserid(ua.getUserid());
        parameters.setUsername(ua.getUsername());
        parameters.setUauditorid(ua.getUauditorid());
        parameters.setUauditor(ua.getUauditor());
            Certifrecord parameters1 = new Certifrecord();
            parameters1.setCrauditor(ua.getUauditor());
            parameters1.setCruserid(ua.getUserid());
            int updatecode = whaAppoveService.updateCertifrecord(parameters1);//修改认证记录表的用户审核人
            if(updatecode<=0){
                code="400";
            }else{
                int addcode = whaAppoveService.addUserauditor(parameters);//增加用户审核表的数据
                if(addcode<=0){
                     code="400";
                }
            }
        return code;
    }
    //用户资料认证
    @RequestMapping("basicInfoApprove")
    private String basicInfoaudit(HttpServletRequest request) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        //查询所有用户
        List<Users> users = usersService.queryUsersPager(null,pageBean);
        //查询出所有用户审核表
        List<Userauditor> userauditors = whaAppoveService.queryUserauditor(null);
        request.setAttribute("users", users);
        request.setAttribute("ua", userauditors);
        request.setAttribute("pageBean",pageBean);
        return str + "basicinfoList";
    }
    @RequestMapping("infoAuditByuser")
    private String infoAuditByuser(Model model,Certifrecord cr){
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        List<Userauditor> userauditors = whaAppoveService.queryUserauditor(parameters);//查询所有的审核表的数据
        parameters.put("cruserid",cr.getCruserid());
        parameters.put("id",cr.getCruserid());
        parameters.put("craiid",cr.getCraiid());
        List<Certifrecord> certifrecords = whaAppoveService.queryCertifrecordPager(parameters,null);//根据用户cruserid与认证项craiid查询认证记录表的数据
        Users user =  usersService.selectByPrimaryKey(cr.getCruserid());//根据ID查询当前用户的信息
        List<Approveitem> approvesall = whaAppoveService.queryApprovesPager(null,null);//认证项表（证件种类）
        model.addAttribute("certrecod",certifrecords);//该用户的认证记录表的数据
        model.addAttribute("user",user);
        model.addAttribute("approve",approvesall);
        model.addAttribute("useraud",userauditors);
        model.addAttribute("craiid",cr.getCraiid());
        return str+"basicuserapprove";
    }
    @RequestMapping("updateInfoAudit")
    @ResponseBody
    private String updateInfoAudit(Certifrecord cr){
        String code="200";
        Date date = new Date();
        cr.setCrdate(date);
        int updateCode = whaAppoveService.updateCertifrecord(cr);
        if(updateCode <=0){
            code = "400";
        }
        return code;
    }

    //认证资料统计
    @RequestMapping("approveStatistics")
    private String approveStatistics(Model model, Certifrecord cr) {
        List<Users> users = usersService.queryUsersPager(null,null);//查询所有用户
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        List<Approveitem> approvesall = whaAppoveService.queryApprovesPager(null,null);//认证项表（证件种类）
        parameters.put("crusername",cr.getCrusername());
        parameters.put("craiid",cr.getCraiid());
        List<Certifrecord> certifrecords = whaAppoveService.queryCertifrecordPager(parameters,null);//根据用户crusername与认证项craiid查询认证记录表的数据
        model.addAttribute("users",users);
        model.addAttribute("approves",approvesall);
        model.addAttribute("cr",certifrecords);
        model.addAttribute("username",cr.getCrusername());
        model.addAttribute("apid", cr.getCraiid());
        return str + "approvestatistics";
    }

    //认证项设置
    @RequestMapping("traverseApproves")
    private String traverseApproves( Approveitem ai,HttpServletRequest request) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("aiid", ai.getAiid());
        parameters.put("ainame", ai.getAiname());
        parameters.put("aitype", ai.getAitype());
        parameters.put("aistate", ai.getAistate());
        List<Approveitem> approves = whaAppoveService.queryApprovesPager(null,pageBean);//认证项表（证件种类）
        request.setAttribute("approveitems", approves);
        request.setAttribute("pageBean", pageBean);
        return str + "approvelist";
    }

    /**
     * 启用与禁用认证项
     * @param ai
     * @return
     */
    @RequestMapping("updateApprove")
    private ModelAndView updateApprove(Approveitem ai) {
        whaAppoveService.updateByPrimaryKeySelective(ai);
        return new ModelAndView("redirect:traverseApproves");
    }

    /**
     * 修改认证项
     * @param ai
     * @param model
     * @return
     */
    @RequestMapping("toupdateApprove")
    private String toupdateApprove(Approveitem ai, Model model) {
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("aiid", ai.getAiid());
        parameters.put("ainame", ai.getAiname());
        parameters.put("aitype", ai.getAitype());
        parameters.put("aistate", ai.getAistate());
        List<Approveitem> approvesall = whaAppoveService.queryApprovesPager(parameters,null);
        Approveitem approve = null;
        if (!approvesall.isEmpty()) {
            approve = approvesall.get(0);
            model.addAttribute("approve", approve);
        }
        return str + "approveupdate";
    }

    /**
     * 跳转到增加认证项的界面
     * @return
     */
    @RequestMapping("toaddApprove")
    private String toaddApprove() {
        return str + "approveadd";
    }
    /**
     *
     * 增加认证项
     * @param ai
     * @return
     */
    @RequestMapping("addApprove")
    private ModelAndView addApprove(Approveitem ai) {
        ai.setAistate("1");
        whaAppoveService.insertSelective(ai);
        return new ModelAndView("redirect:traverseApproves");
    }

}
