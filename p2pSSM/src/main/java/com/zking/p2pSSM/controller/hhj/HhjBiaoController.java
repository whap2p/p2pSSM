package com.zking.p2pSSM.controller.hhj;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.service.hhj.IBiaoService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author标题
 * @site www.xiaomage.com
 * @company xxx公司
 * @create  2019-03-08 16:33
 */
@Controller
@RequestMapping("/hhjbiao")
public class HhjBiaoController {
    final String str = "WEB-INF/view/";
    @Autowired
    IBiaoService iBiaoService;

    /**
     * 到添加界面
     * @param model
     * @return
     */
    @RequestMapping("/input")
    public String biaoinput(Model model){
        return str + "bk_input_biao";
    }
    /**
     * 查询
     * @param request
     * @return
     */
    @RequestMapping("/show")
    public String ShowBiao(HttpServletRequest request){
        System.out.println("我来了");
        try {
            PageBean pageBean=new PageBean();
            pageBean.setPage(request.getParameter("currpage")==null?1:Integer.parseInt(request.getParameter("currpage")));
            List<Biao> productshow =iBiaoService.ShowBiaoPager(pageBean);
            request.setAttribute("hhjBiaoshow",productshow);
            request.setAttribute("hhjBiaoshowsize",pageBean.getTotal());
            request.setAttribute("hhjBiaoshowPage",pageBean.getPage());
            request.setAttribute("hhjBiaoshowPageMax",pageBean.getMaxPage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return str+"bk_biao_list";
    }

    /**
     * 删除
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    public String deleteBiao(HttpServletRequest request){
        try {
            iBiaoService.deleteByPrimaryKey(Integer.valueOf(request.getParameter("id")));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:show";
    }

    /**
     * 赋值
     * @param request
     * @return
     */
    @RequestMapping("/update1")
    public String updateBiao1(HttpServletRequest request){
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("bname",request.getParameter("bname"));
        return str+"bk_input_biao";
    }

    /**
     * 添加修改
     * @param request
     * @return
     */
    @RequestMapping("/addupdate")
    public String updateBiao(HttpServletRequest request){
        Biao biao=new Biao();
        biao.setBname(request.getParameter("bname"));
        try {
            if(request.getParameter("id")!=""){
                biao.setId(Integer.valueOf(request.getParameter("id")));
                iBiaoService.updateByPrimaryKey(biao);
            }else {
                System.out.println("我来修改了");
                iBiaoService.insert(biao);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:show";
    }

}
