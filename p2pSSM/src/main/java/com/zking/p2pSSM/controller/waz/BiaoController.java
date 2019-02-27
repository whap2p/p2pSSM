package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.service.waz.BiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/biao")
public class BiaoController {

    @Autowired
    private BiaoService biaoService;


    @RequestMapping("/list")
    public String query(HttpServletRequest request){
        List<Biao> list = biaoService.query();
        request.setAttribute("biao",list);
        return "list";
    };

}
