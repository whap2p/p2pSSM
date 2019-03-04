package com.zking.p2pSSM.controller.waz;

import com.zking.p2pSSM.model.Users;
import com.zking.p2pSSM.service.waz.UsersService;
import com.zking.p2pSSM.utils.LoginCodeUtil;
import com.zking.p2pSSM.utils.QrCoreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    /**
     * 跳转二维码登录页面
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        mv.addObject("uuid", uuid);
        mv.setViewName("login");
        return mv;
    }


    /**
     * 返回二维码
     * @param uuid
     * @param response
     */
    @RequestMapping("/code/{uuid}")
    public void code(@PathVariable("uuid")String uuid , HttpServletResponse response){
        System.out.println("+++开始扫码");
        String content = "http://192.168.43.39:8080/p2pSSM/users/scan/" + uuid;   //手机扫码的二维码地址
        LoginCodeUtil.set(uuid, 0);
        BufferedImage imageCode = QrCoreUtil.getQrCode(content);
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(imageCode, "png", os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 二维码验证
     * @param uuid
     * @return
     */
    @RequestMapping(value="/validate",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> validate(@RequestParam("uuid")String uuid){
        Map<String, Object> map = new HashMap<String, Object>();
        long begin = System.currentTimeMillis();
        while(true){
            long curr = System.currentTimeMillis();
            if( curr - begin > 60 *1000){                           //1分钟超时
                LoginCodeUtil.remove(uuid);
                map.put("state", -3);
                System.out.println("二维码验证超时。。。");
                break;
            }
            int state = LoginCodeUtil.get(uuid);
            if( state == -3){
                map.put("state", -3);
                break;
            }
            else if( state == 1){
                map.put("state", 1);
                map.put("msg", "二维码正在扫码。。。");
                LoginCodeUtil.set(uuid, -1);
                break;
            }
            else if( state == 2){
                map.put("state", 2);
                map.put("msg", "扫描完成");
                LoginCodeUtil.remove(uuid);
                break;
            }
            else if( state == -2){
                map.put("state", -2);
                map.put("msg", "取消登录");
                LoginCodeUtil.remove(uuid);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }

        return map;
    }

    /**
     * 手机确认二维码
     * @param uuid
     * @return
     */
    @RequestMapping("/scan/{uuid}")
    public ModelAndView scan(@PathVariable("uuid")String uuid){
        ModelAndView mv = new ModelAndView();
        int state = LoginCodeUtil.get(uuid);
        if( state == -3){
            mv.addObject("state", state);
        }
        else {
            LoginCodeUtil.set(uuid, 1);
            mv.addObject("state", 1);
        }
        mv.setViewName("scan");
        return mv;
    }

    /**
     * 确认按钮
     * @param uuid
     * @param typeStr
     * @return
     */
    @RequestMapping(value="/do")
//    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request,String uuid, String typeStr){
        Map<String, Object> map = new HashMap<String, Object>();
        int value = LoginCodeUtil.get(uuid);
        if(value == -3){
            map.put("state", -3);
            return map;
        }
        int type = Integer.parseInt(typeStr);
        if( type == 2){ //确认
            Users users = new Users();
            users.setUnickname("test");
            users.setUpassword("123");
            Users login = usersService.login(users);
            request.setAttribute("globaluser", login);
            LoginCodeUtil.set(uuid, 2);
            map.put("state", 2);
        }
        else if ( type == -2){ //取消
            LoginCodeUtil.set(uuid, -2);
            map.put("state", -2);
        }
        return map;
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("globaluser");
        return "index";
    }

}
