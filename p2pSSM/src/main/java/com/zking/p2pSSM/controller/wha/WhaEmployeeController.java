package com.zking.p2pSSM.controller.wha;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zking.p2pSSM.model.Dept;
import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.service.wha.DeptService;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import com.zking.p2pSSM.utils.DateUtil;
import com.zking.p2pSSM.utils.PageBean;
import com.zking.p2pSSM.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employee/")
public class WhaEmployeeController {
	final String str = "WEB-INF/view/";
	@Autowired
	WhaEmployeeService whaEmployeeService;
	@Autowired	
	private DeptService deptService;
	@RequestMapping("list")
	public String employeelist(Model model,HttpServletRequest request,Employee employee){
		PageBean pageBean=new PageBean();
		pageBean.setRequest(request);
		List<Employee> emplist = whaEmployeeService.queryEmployeePager(employee,pageBean);
		request.setAttribute("emp", emplist);
		// 查询部门
		List<Dept> deptlist = deptService.queryDeptPager(null,null);
		request.setAttribute("depts", deptlist);
		request.setAttribute("pageBean",pageBean);
		return str + "bk_emplist";
	}
	@RequestMapping("toadd")
	public String inserts(Model model) {
		List<Dept> deptlist = deptService.queryDeptPager(null,null);
		model.addAttribute("dept", deptlist);
		return str+"bk_empadd";
	}
    @RequestMapping("add")
    public String add(Model model, Employee emp,
                      @RequestParam(value = "ebirths") String ebirths,
                      @RequestParam(value = "etimes") String etimes) {
        // 设置性别
        String esex = emp.getEsex();
        if (esex.equals("0")) {
            emp.setEsex("女");
        } else {
            emp.setEsex("男");
        }
        emp.setEbirth(DateUtil.strchangedate(ebirths));
        emp.setEtime(DateUtil.strchangedate(etimes));
		//盐
		String salt = PasswordHelper.createSalt();
		emp.setEsalt(salt);
		//凭证+盐加密后得到的密码
		String credentials = PasswordHelper.createCredentials(emp.getEpassword(), salt);
		emp.setEpassword(credentials);
        whaEmployeeService.insertSelective(emp);
        return "redirect:/employee/list";
    }
	@RequestMapping("del")
	public String del(@RequestParam(value = "eid", required = false) Integer eid) {
		whaEmployeeService.deleteByPrimaryKey(eid);
		return "redirect:/employee/list";
	}
	@RequestMapping("toupd")
	public String toupd(
			@RequestParam(value = "eid", required = false) Integer eid,
			Model model) {
		// 查询结果
		Employee ee = whaEmployeeService.selectByPrimaryKey(eid);
		model.addAttribute("ee", ee);
		// 查询部门
		List<Dept> deptlist = deptService.queryDeptPager(null,null);
		model.addAttribute("dept", deptlist);
		return str+"bk_empupd";
	}
	@RequestMapping("upd")
	public String upd(Employee emp,
					  @RequestParam(value = "ebirths") String ebirths,
					  @RequestParam(value = "etimes") String etimes) {
		// 设置性别
		String esex = emp.getEsex();
		if (esex.equals("0")) {
			emp.setEsex("女");
		} else {
			emp.setEsex("男");
		}
		emp.setEbirth(DateUtil.strchangedate(ebirths));
		emp.setEtime(DateUtil.strchangedate(etimes));
		//盐
		String salt = PasswordHelper.createSalt();
		emp.setEsalt(salt);
		//凭证+盐加密后得到的密码
		String credentials = PasswordHelper.createCredentials(emp.getEpassword(), salt);
		emp.setEpassword(credentials);
		whaEmployeeService.updateByPrimaryKeySelective(emp);
		return "redirect:/employee/list";
	}

}
