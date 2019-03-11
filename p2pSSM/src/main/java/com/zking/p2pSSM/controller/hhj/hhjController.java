package com.zking.p2pSSM.controller.hhj;


import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class hhjController {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       String ss=df.format(new Date());
        System.out.println(df.format(new Date()));
    }
}
