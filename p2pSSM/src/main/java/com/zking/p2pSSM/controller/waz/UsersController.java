package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @RequestMapping("/login")
    public String  login(HttpServletRequest request, Users users){
        Users login = usersService.login(users);
        if(login != null){
            request.setAttribute("globaluser",login);
            return "index";
        }else{
            return "login";
        }
    }

}
