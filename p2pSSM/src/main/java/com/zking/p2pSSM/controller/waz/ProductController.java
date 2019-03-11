package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.*;
import com.zking.p2pSSM.service.waz.*;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
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
    @Autowired
    private UsersService usersService;
    @Autowired
    private CertificationService certificationService;


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

    /**
     * 投资详情查询
     * @param request
     * @param id
     * @param unickname
     * @return
     */
    @RequestMapping("/queryById")
    public String queryById(HttpServletRequest request,Integer id,String unickname){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        Investinfo investinfo = new Investinfo();
        investinfo.setBrrowid(id);


        Product product = productService.selectByPrimaryKey(id);
        List<Details> detailsList = detailsService.queryPager(null, null);
        List<Investinfo> investinfoList = investinfoService.queryPager(investinfo, pageBean);
        int sumBYInmoney = investinfoService.sumBYInmoney(investinfo);
        int sumBYProfitmoney = investinfoService.sumBYProfitmoney(investinfo);
        List<Biao> biaos = biaoService.query();
        List<Users> users = usersService.selectPager();
        Certification certification = certificationService.queryByCusername(unickname);


        request.setAttribute("Details",detailsList);
        request.setAttribute("Borrowmoney",product);
        request.setAttribute("record",investinfoList);
        request.setAttribute("biao",biaos);
        request.setAttribute("user",users);
        request.setAttribute("sumBYInmoney",sumBYInmoney);
        request.setAttribute("sumBYProfitmoney",sumBYProfitmoney);
        request.setAttribute("certification",certification);
        return "infor";
    }

    /**
     * 投资
     * @return
     */
    @RequestMapping(value = "/touZi")
    public String touZi(Integer id, Integer userid, BigDecimal inmoney, String cbalance, Integer brrowid, String interest, String profitmodel, String instatus, String brrowstatus, BigDecimal profitmoney , String replaydate, Integer markstatus,String unickname){

        Certification certification = new Certification();
        certification.setCbalance(cbalance);
        certification.setId(id);

        Investinfo investinfo = new Investinfo();
        investinfo.setUserid(userid);
        investinfo.setBrrowstatus(brrowstatus);
        investinfo.setInmoney(inmoney);
        investinfo.setInstatus(instatus);
        investinfo.setMarkstatus(markstatus);
        investinfo.setInterest(interest);
        investinfo.setProfitmodel(profitmodel);
        investinfo.setProfitmoney(profitmoney);
        investinfo.setReplaydate(replaydate);
        investinfo.setBrrowid(brrowid);
        investinfo.setIndate(new Date());
        investinfo.setInstyle("钱多多");


        int addInvestinfo = investinfoService.insertSelective(investinfo);
        int updateByCbalance = certificationService.updateByCbalance(certification);
        return  "product/queryById?id="+brrowid+"&&unickname="+unickname;
    }


}
