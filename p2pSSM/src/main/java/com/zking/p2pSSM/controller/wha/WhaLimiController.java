package com.zking.p2pSSM.controller.wha;


import com.zking.p2pSSM.model.Limi;
import com.zking.p2pSSM.service.wha.DeptService;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import com.zking.p2pSSM.service.wha.WhaLimiService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("limit")
public class WhaLimiController {
	final String str = "WEB-INF/view/";
    @Autowired
    WhaLimiService whaLimitService;
    @Autowired
    WhaEmployeeService whaEmployeeService;
    @Autowired
    DeptService deptService;

	@RequestMapping("findlist")
    public String findlist(HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List list=deptService.queryDeptPager(null,pageBean);
        request.setAttribute("deptlist",list);
        request.setAttribute("pageBean",pageBean);
        return str+"limit";
    }
    @RequestMapping("toupd")
    public String toupd(Limi li,@RequestParam(value = "did", required = false) Integer did,
                        HttpServletRequest requeset,
                        Model model){
        //根据ID查询权限
        li.setDid(did);
        List list = whaLimitService.queryLimiPager(li,null);
        List list2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Limi limi = (Limi) list.get(i);
            list2.add(limi.getMid());
        }
        //将list 返回到页面
        requeset.setAttribute("listss", list2);
        System.out.println(list.size());
        model.addAttribute("did", did);
        return str+"limitupd";
    }
    @RequestMapping("upd")
    public String upd(@RequestParam(value = "did", required = false) Integer did,
                      @RequestParam(value = "inp", required = false) String [] rools,
                      Model model){
        //先清空原有的数据（删除）--根据ID查询  很多数据
        whaLimitService.deleteByPrimaryKey(did);
        if( rools==null || "".equals(rools)){
            System.out.println("rools大小为0");
        }else{
            for (int i = 0; i < rools.length; i++) {
                Limi limit = new Limi();
                limit.setMid(rools[i]);
                limit.setDid(did);
                //执行添加的方法
                whaLimitService.insertSelective(limit);
            }
        }
        return "redirect:/limit/findlist";
    }



}
