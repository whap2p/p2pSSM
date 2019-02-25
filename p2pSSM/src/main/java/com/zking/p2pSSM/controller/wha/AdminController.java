package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.service.wha.AdminService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {
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
}
