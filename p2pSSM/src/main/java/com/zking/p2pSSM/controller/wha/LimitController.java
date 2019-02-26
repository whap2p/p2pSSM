package com.zking.p2pSSM.controller.wha;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("limit")
public class LimitController {
	final String str = "WEB-INF/view/";
	@RequestMapping("findlist")
    public String findlist(Model model){
        return str+"limit";
    }

}
