package zking.impl;

import com.zking.p2pSSM.model.Admin;
import com.zking.p2pSSM.model.Limi;
import com.zking.p2pSSM.model.Withdrawal;
import com.zking.p2pSSM.service.wha.AdminService;
import com.zking.p2pSSM.service.wha.WhaLimiService;
import com.zking.p2pSSM.utils.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zking.base.SpringJunitTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AdminServiceImplTest extends SpringJunitTest {
    @Autowired
    private AdminService adminService;
    @Autowired
    WhaLimiService whaLimitService;
    @Test
    public void queryByUserName() {
        //分页查询
        PageBean pageBean = new PageBean();
        pageBean.setPage(2);
        Admin admin = new Admin();
        List<Admin> list = adminService.queryAdminPager(admin, pageBean);
        System.out.println(list.size());
        for (Admin h : list) {
            System.out.println(h);
        }

    }
}