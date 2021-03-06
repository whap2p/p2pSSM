package com.zking.p2pSSM.controller.wha;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.wha.WhaUsersService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users/")
public class WhaUsersController {
	final String str = "WEB-INF/view/";
	//用户管理
	@Autowired
	WhaUsersService usersService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, Users users) {
		PageBean pageBean=new PageBean();
		pageBean.setRequest(request);
		System.out.println(users.getUnickname());
		List<Users> ulist = usersService.queryUsersPager(users,pageBean);
		request.setAttribute("ulist",ulist);
		request.setAttribute("pageBean",pageBean);
		return str+"bk_userslist";
	}

}
