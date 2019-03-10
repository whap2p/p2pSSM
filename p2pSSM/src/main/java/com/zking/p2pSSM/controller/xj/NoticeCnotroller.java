package com.zking.p2pSSM.controller.xj;

import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.service.xj.XJNoticeService;
import com.zking.p2pSSM.utils.DateUtil;
import com.zking.p2pSSM.utils.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author @我只是健健吖
 * @create  2019-03-06 上午 8:42
 */
@Controller
@RequestMapping("/notice")
public class NoticeCnotroller {
    final String str = "WEB-INF/view/";
    @Autowired
    XJNoticeService xjNoticeService;

    @RequestMapping("/notlists")
    public  String  findallnotice(HttpServletRequest request , String noticetype ){
        PageBean pageBean =new PageBean();
        pageBean.setRequest(request);
        List noticelist = xjNoticeService.queryNoticePager(noticetype, pageBean);
        request.setAttribute("pagebean",pageBean);
        request.setAttribute("noticelist",noticelist);
        return  str+"noticeaddlist";
    }
    @RequestMapping("/notlist")
    public  String  findallnotices(HttpServletRequest request , String noticetype ){
        PageBean pageBean =new PageBean();
        pageBean.setRequest(request);
        List noticelist = xjNoticeService.queryoneNoticePager(noticetype, pageBean);
        request.setAttribute("pagebean",pageBean);
        request.setAttribute("noticelist",noticelist);
        return  str+"noticeaddlist";
    }


   @RequestMapping("/notadd")
   public String addNotice(String noticetitle ,String  noticetype, String noticecontent, MultipartFile ufile){
       try {
           FileUtils.copyInputStreamToFile(ufile.getInputStream(),new File("D://image/"+ufile.getOriginalFilename()));
       } catch (IOException e) {
           e.printStackTrace();
       }
       Notice notice =new Notice();
       notice.setNoticetitle(noticetitle);
       notice.setNoticetype(noticetype);
       notice.setNoticecontent(noticecontent);
       notice.setNoticepicture("/images/"+ufile.getOriginalFilename());
       notice.setNoticelasttime(new Date());
       int i = xjNoticeService.insertSelective(notice);
       if(i==1){
           System.out.println("增加通知成功");
       }
       return  str+"noticeadd";
    }


    @RequestMapping("/toaddlisttupian")
    public String findimg(HttpServletRequest request){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List imglist = xjNoticeService.queryimgPager(pageBean);
        request.setAttribute("imglist",imglist);
        request.setAttribute("pageBean",pageBean);
        return str+"noticeaddlisttupian";
    }



   @RequestMapping("/addimg")
   public String addNoticeimg(String noticetitle ,String  noticetype, String noticecontent, MultipartFile ufile){
        try {
            FileUtils.copyInputStreamToFile(ufile.getInputStream(),new File("D://image/"+ufile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Notice notice =new Notice();
        notice.setNoticetitle(noticetitle);
        notice.setNoticetype(noticetype);
        notice.setNoticecontent(noticecontent);
        notice.setNoticepicture("/images/"+ufile.getOriginalFilename());
        notice.setNoticelasttime(new Date());
        int i = xjNoticeService.insertSelective(notice);
        if(i==1){
            System.out.println("增加通知成功");
        }
        return  str+"noticeaddtupian";
    }

    @RequestMapping("/notimgdel")
    public String delnoticeimg(Integer noticeid){
        int i = xjNoticeService.deleteByPrimaryKey(noticeid);
        return "redirect:/notice/toaddlisttupian";
    }
    @RequestMapping("/notdel")
    public String delnotice(Integer noticeid){
        int i = xjNoticeService.deleteByPrimaryKey(noticeid);
        return "redirect:/notice/notlists";
    }

    @RequestMapping("/findone")
    public String findbyid(Integer noticeid,HttpServletRequest request){
        Notice notice = xjNoticeService.selectByPrimaryKey(noticeid);
        request.setAttribute("nots",notice);
        return  str+"noticeupdate";
    }

   @RequestMapping("/updno")
    public  String updnotice(Notice notice){
       int i = xjNoticeService.updateByPrimaryKeySelective(notice);
       return "redirect:/notice/notlists";
    }


}
