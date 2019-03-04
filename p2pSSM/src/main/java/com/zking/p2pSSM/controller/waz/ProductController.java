package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.model.Details;
import com.zking.p2pSSM.model.Investinfo;
import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.service.impl.waz.InvestinfoService;
import com.zking.p2pSSM.service.waz.BiaoService;
import com.zking.p2pSSM.service.waz.DetailsService;
import com.zking.p2pSSM.service.waz.ProductService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BiaoService biaoService;
    @Autowired
    private DetailsService detailsService;
    @Autowired
    private InvestinfoService investinfoService;


    /**
     * 投标列表查询，带模糊查
     * @param request
     * @param item
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, String item,Integer param){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        Product product= new Product();
        if(item != null){
            if(item.equals("itemtype")){
                if(param == -1){
                    product.setPtype(null);
                }else{
                    product.setPtype(param);
                    request.setAttribute("biaoId",product.getPtype());
                }
            }else if(item.equals("repayway")){

                if(param == 1){
                    product.setPway("到期还本付息");
                }else if(param == 2){
                    product.setPway("按月付息,到期还本");
                }else if(param == 3){
                    product.setPway("等额本息");
                }else if(param == -1){
                    product.setPway(null);
                }
                request.setAttribute("pway",product.getPway());
            } else if(item.equals("rate")){
                if(param == -1){
                    product.setPincome(null);
                }else if(param == 1){
                    product.setPincome("0");
                }else if(param == 2){
                    product.setPincome("12");
                }else if(param == 3){
                    product.setPincome("14");
                }else if(param == 4){
                    product.setPincome("16");
                }
            }else if(item.equals("timelimit")){
                if(param==-1){
                    product.setPcount(null);
                }else if(param==1){
                    product.setPcount(null);
                }else if(param==2){

                }else if(param==3){

                }else if(param==4){

                }else if(param==5){

                }
            }
        }

        List<Product> list = productService.queryPager(product, pageBean);
        List<Biao> biaos = biaoService.query();
        request.setAttribute("biao",biaos);
        request.setAttribute("list",list);
        request.setAttribute("pageBean",pageBean);
        return "list";
    }


    @RequestMapping("/queryById")
    public String queryById(HttpServletRequest request,Integer id,Integer userid){
        Product product = productService.selectByPrimaryKey(id);
        List<Details> detailsList = detailsService.queryPager(null, null);
        request.setAttribute("Details",detailsList);
        request.setAttribute("Borrowmoney",product);
        if(userid != null){
            Investinfo investinfo = new Investinfo();
            investinfo.setUserid(userid);
            List<Investinfo> investinfoList = investinfoService.queryPager(investinfo, null);
            request.setAttribute("record",investinfoList);
        }
        return "infor";
    }

}
