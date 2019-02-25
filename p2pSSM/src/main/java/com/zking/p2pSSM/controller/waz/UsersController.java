package com.zking.p2pSSM.controller.waz;


import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户登陆
     * @param request
     * @param users
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Users users){
        try {
            Users user = usersService.queryByNamePager(users);
            request.setAttribute("user",user);
            return "index";
        }catch (Exception e){
            return "login";
        }
    }

    /**
     * 查看我的账户
     * @param request
     * @param uid
     * @return
     */
    @RequestMapping("/queryById/{uid}")
    public String queryById(HttpServletRequest request,@PathVariable(value = "uid")Integer uid){
        Users users = usersService.selectByPrimaryKey(uid);
        request.setAttribute("user",users);
        return "personalpage";
    }

    @RequestMapping("/updateByKH")
    public String updateByKH(Users users){
        usersService.updateByKH(users);
        return "thirdparty";
    }

}
