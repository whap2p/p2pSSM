package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.model.Certifrecord;
import com.zking.p2pSSM.service.wha.AdminService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
    String str = "WEB-INF/view/";
    @Autowired
    AdminService adminService;
    @RequestMapping("/indexs")
    public String list(HttpServletRequest request, Admin admin) {
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        System.out.println(pageBean.toString());
        List<Admin> list = this.adminService.queryAdminPager(admin, pageBean);
        request.setAttribute("adminlist", list);
        request.setAttribute("pageBean",pageBean);
        return "WEB-INF/view/indexs";
    }
    @RequestMapping("/bk_login")
    public String bk_index(HttpServletRequest request, Admin admin) {
        return "WEB-INF/view/bk_login";
    }
    @RequestMapping("/common")
    public String common(HttpServletRequest request, Admin admin) {
        return "WEB-INF/view/common";
    }
    //新用户认真资料 头部
    @RequestMapping("newuserInfoList")
    private String newuserInfoList(Model model) {
        return str + "anewuserinfolist";
    }
    //资料认证
    @RequestMapping("basicInfoApprove")
    private String basicInfoaudit(Model model,@RequestParam(value = "currpage", required = false) String currpage) {
        return str+"basicinfoList";
    }
    //认证资料统计
    @RequestMapping("approveStatistics")
    private String approveStatistics(Model model, Certifrecord cr, @RequestParam(value = "currpage", required = false) String currpage){
        return str+"approvestatistics";
    }
    //信用额度申请
    @RequestMapping("limitApplyfor")
    private String limitApplyfor(Model model){
        return str+"limitapplyforlist";
    }

    }
