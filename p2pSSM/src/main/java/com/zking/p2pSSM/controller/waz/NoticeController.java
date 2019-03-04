package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Biao;
import com.zking.p2pSSM.model.Notice;
import com.zking.p2pSSM.model.Product;
import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.BiaoService;
import com.zking.p2pSSM.service.waz.NoticeService;
import com.zking.p2pSSM.service.waz.ProductService;
import com.zking.p2pSSM.service.waz.UsersService;
import com.zking.p2pSSM.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BiaoService biaoService;


    @RequestMapping("/list")
    public String list(HttpServletRequest request, Notice notice, String url) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Notice> list = noticeService.queryByIdPager(notice, pageBean);

        request.setAttribute("listss", list);
        request.setAttribute("pageBean", pageBean);
        for (Notice notice1 : list) {
            List<Notice> image = new ArrayList<>();
            if (notice1.getNoticetype() == "6") {
                image.add(notice1);
            }
        }
        if (url != null) {
            return url;
        } else {
            return "index";
        }
    }

    /**
     * noticetype    公告类型(1网站公告;2.媒体报道;3.管理团队;4,合作伙伴;5.团队风采,6.首页图片和网址)
     *
     * @param request
     * @return
     */
    @RequestMapping("/query")
    public String query(HttpServletRequest request) throws ParseException {
        //网站公告
        List<Notice> listByWzgg = noticeService.queryByType("1");
        //网站公告最新5条
        List<Notice> listByTop = noticeService.queryByTop("1");
        //媒体报道
        List<Notice> listByMtbd = noticeService.queryByType("2");
//        首页图片和网址
        List<Notice> image = noticeService.queryByType("6");
        //注册人数
        int size = usersService.userCount();
        //主页查询累计投资金额
        int userCountByMarkmoney = usersService.userCountByMarkmoney();
        //主页查询累积收益
        int userCountByMarkgain = usersService.userCountByMarkgain();

        //主页项目
        List<Product> proList = productService.queryPager(null, null);
        List<Biao> biaoList = biaoService.query();
//        扫码登陆后默认用户登陆
//        if(state == 2){
//            Users users = new Users();
//            users.setUnickname("test");
//            users.setUpassword("123");
//            Users login = usersService.login(users);
//            request.setAttribute("globaluser", login);
//        }
        //网站运营天数
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin = dfs.parse("2019-02-23 00:00:00");
        Date end = dfs.parse(format);
        long between = (end.getTime() - begin.getTime()) / 1000;
        //除以1000是为了转换成秒
        long day1 = between / (24 * 3600);
        long hour1 = between % (24 * 3600) / 3600;
        long minute1 = between % 3600 / 60;
        long second1 = between % 60 / 60;
        String date = day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒";

//        request.setAttribute("state", state);
        request.setAttribute("listss", listByWzgg);
        request.setAttribute("listByTop", listByTop);
        request.setAttribute("listByMtbd", listByMtbd);
        request.setAttribute("image", image);
        request.setAttribute("size", size);
        request.setAttribute("date", date);
        request.setAttribute("proList", proList);
        request.setAttribute("biaoList", biaoList);
        request.setAttribute("userCountByMarkmoney", userCountByMarkmoney);
        request.setAttribute("userCountByMarkgain", userCountByMarkgain);
        return "index";
    }

}
