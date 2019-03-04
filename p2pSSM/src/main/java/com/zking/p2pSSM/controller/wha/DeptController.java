package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.service.wha.DeptService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("dept/")
public class DeptController {
    final String str = "WEB-INF/view/";
    @Autowired
    DeptService deptService;
    @RequestMapping("findall")
    public String findall(HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        List list=deptService.queryDeptPager(null,pageBean);
        request.setAttribute("deptlist",list);
        request.setAttribute("pageBean",pageBean);
        return str + "bk_deptlist";
    }
    @RequestMapping("toadd")
    public String inserts() {
        return str+"bk_deptadd";
    }
    @RequestMapping("insert")
    public String insert(Dept dept, Model model, @RequestParam(value = "dname", required = false) String dname,
                         @RequestParam(value = "describe", required = false) String describe) {
        dept.setDname(dname);
        dept.setDescribes(describe);
        deptService.insertSelective(dept);
        return "redirect:/dept/findall";
    }
    @RequestMapping("del")
    public String del(@RequestParam(value = "did", required = false) Integer did) {
        deptService.deleteByPrimaryKey(did);
        return "redirect:/dept/findall";
    }
    @RequestMapping("toupd")
    public String toupd(@RequestParam(value = "did", required = false) Integer did, Model model) {
        Dept dept = deptService.selectByPrimaryKey(did);
        model.addAttribute("dept", dept);
        return str+"bk_deptupd";
    }
    @RequestMapping("upd")
    public String upd(@RequestParam(value = "did", required = false) Integer did,
                      @RequestParam(value = "dname", required = false) String dname,
                      @RequestParam(value = "describes", required = false) String describes) {
        Dept dept = deptService.selectByPrimaryKey(did);
        dept.setDescribes(describes);
        dept.setDname(dname);
        deptService.updateByPrimaryKeySelective(dept);
        return "redirect:/dept/findall";
    }
}
