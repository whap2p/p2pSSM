package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.service.wha.AdminService;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/log")
public class AdminController {
    final String str = "WEB-INF/view/";
    @Autowired
    AdminService adminService;
    @Autowired
    WhaEmployeeService whaEmployeeService;
    /**
     * 首页:未登录不可访问
     * @param request
     * @param admin
     * @return
     */
    @RequiresUser
    @RequestMapping("/indexs")
    public String list(HttpServletRequest request, Admin admin) {
        return str+"bk_index";
    }

    /**
     * 退出到登录
     * @return
     */
    @RequestMapping("/to_login")
    public String tologin() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return str+"bk_login";
    }

    /**
     * 登录成功跳到首页
     * @param user
     * @param password
     * @return
     */
    @RequestMapping("/user_L")
    public String user_L(HttpServletRequest request,@RequestParam(value = "user", required = false) String user,
                         @RequestParam(value = "password", required = false) String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(user, password);
        Subject subject = SecurityUtils.getSubject();
        System.out.println(user+password);
        try {
            subject.login(token);
            Employee employee = this.whaEmployeeService.selectByPrimaryKeyename(user);
            request.getSession().setAttribute("globalemp",employee);
            request.getSession().setMaxInactiveInterval(120*60);
            System.out.println("登录成功");
           return str+"bk_index";
       }catch (Exception e){
            System.out.println("登录失败");
            return "redirect:to_login";
         }
    }

}
