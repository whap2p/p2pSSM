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
public class WithdrawalController {
    final String str = "WEB-INF/view/";
    @Autowired
    DeptService deptService;

}
