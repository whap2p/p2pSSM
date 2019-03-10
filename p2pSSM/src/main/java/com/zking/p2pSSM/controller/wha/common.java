package com.zking.p2pSSM.controller.wha;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.model.Certifrecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class common {
    final String str = "WEB-INF/view/";
    //1首页
//    @RequestMapping("log/bkindex")
//    public String tologin(Model model) {
//        return str+"bk_index";
//    }
    //2管理组
    //部门管理
//    @RequestMapping("dept/findall")
//    public String findall(Model model){
//        return str + "bk_deptlist";
//    }
//    //员工管理
//    @RequestMapping("employee/list")
//    public String employeelist(Model model){
//        return str + "bk_emplist";
//    }
//    //用户管理
//    @RequestMapping("users/list")
//    public String userslist(Model model){
//        return str + "bk_userslist";
//    }
    //3网站内容管理
    //添加网站通知
    @RequestMapping("notice/toadd")
    public String tohoutai(Model model){
        return str + "noticeadd";
    }
    //查询网站通知
    @RequestMapping("notice/notlists")
    public String notlist(Model model){
        return str + "noticeaddlist";
    }
    //添加网站首页图片
    @RequestMapping("notice/addtupian")
    public String addtupian(Model model){
        return str + "noticeaddtupian";
    }
    //查询首页图片
    @RequestMapping("notice/toaddlisttupian")
    public String toaddlisttupian(Model model){
        return str + "noticeaddlisttupian";
    }
    //4财务管理
    //提现管理
//    @RequestMapping("wd/wlist")
//    public String withdrawallist(Model model){
//        return str + "Withdrawallist";
//    }
//    //银行卡管理
//    @RequestMapping("bc/bankcard")
//    public String bankcard(Model model){
//        return str + "BankCardllist";
//    }
//    //充值记录
//    @RequestMapping("wd/rech")
//    public String rech(Model model){
//        return str + "Rechargelist";
//    }
//    //手续费记录
//    @RequestMapping("wd/poundage")
//    public String bankcardpoundage(Model model){
//        return str + "Poundagelist";
//    }
//    //交易记录
//    @RequestMapping("td/trade")
//    public String bankcardtrade(Model model){
//        return str + "Tradelist";
//    }
//    //借贷信息列表
//    @RequestMapping("brower/hjyList")
//    public String hjyList(Model model){
//        return str + "Borrowmoneylist";
//    }
    //5借贷管理
    //投标列表
    @RequestMapping("product/list0")
    public String list(Model model){
        return str + "bk_list_pro";
    }
    //添加投标
    @RequestMapping("product/addbiao")
    public String addpro(Model model){
        return str + "bk_input_pro";
    }
    //标种列表
    @RequestMapping("biao/list")
    public String biaolist(Model model){
        return str + "bk_biao_list";
    }
    //添加标种
    @RequestMapping("biao/input")
    public String biaoinput(Model model){
        return str + "bk_input_biao";
    }
    //所有借款
    @RequestMapping("brower/qurey")
    public String allMoney(Model model){
        return str + "bk_moneylist";
    }
    //待审核的借款
    @RequestMapping("brower/check")
    public String browerlist(Model model){
        return str + "bk_list_pro";
    }
    //招标中的借款
//    @RequestMapping("product/list")
//    public String list(Model model){
//        return str + "bk_list_pro";
//    }
    //还款
    @RequestMapping("brower/tohk")
    public String bk_huankuanlist(Model model){
        return str + "bk_huankuanlist";
    }
    //满标借款
//    @RequestMapping("product/list")
//    public String list(Model model){
//        return str + "bk_list_pro";
//    }
    //还款方式
//    @RequestMapping("product/list")
//    public String list(Model model){
//        return str + "bk_list_pro";
//    }
    //6认证项管理
//    //新用户认证资料
//    @RequestMapping("approve/anewuserInfoList")
//    private String newuserInfoList(Model model) {
//        return str + "anewuserinfolist";
//    }
//    //用户资料认证
//    @RequestMapping("approve/basicInfoApprove")
//    private String basicInfoaudit(Model model,@RequestParam(value = "currpage", required = false) String currpage) {
//        return str+"basicinfoList";
//    }
//    //认证资料统计
//    @RequestMapping("approve/approveStatistics")
//    private String approveStatistics(Model model, Certifrecord cr, @RequestParam(value = "currpage", required = false) String currpage){
//        return str+"approvestatistics";
//    }
//    //信用额度申请
//    @RequestMapping("approve/limitApplyforlist")
//    private String limitApplyfor(Model model){
//        return str+"limitapplyforlist";
//    }
//    //认证项设置
//    @RequestMapping("approve/traverseApproves")
//    private String traverseApproves(Model model){
//        return str + "approvelist";
//    }
    //7权限管理
    //权限列表
//    @RequestMapping("limit/findlist")
//    public String findlist(Model model){
//        return str+"limit";
//    }

}
