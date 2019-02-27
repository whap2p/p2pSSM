package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.service.waz.BiaoService;
import com.zking.p2pSSM.service.waz.ProductService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @RequestMapping("/list")
    public String list(HttpServletRequest request, String item,Integer param){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        System.out.println("--------------"+param);
        Product product= new Product();
        if(item != null){
            if(item.equals("itemtype")){
                if(param == -1){
                    product.setPtype(null);
                }else{
                    product.setPtype(param);
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

            }
        }
        System.out.println("------------------"+product.getPtype());

        List<Product> list = productService.queryPager(product, pageBean);
        List<Biao> biaos = biaoService.query();
        request.setAttribute("biao",biaos);
        request.setAttribute("list",list);
        return "list";
    }
}
