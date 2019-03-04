package com.zking.p2pSSM.shiro;

import com.zking.p2pSSM.model.dh.Users;
import com.zking.p2pSSM.service.dh.DhUsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 14:15
 *
 *  该类realm定义的作用是为了将 shiro的ini文件替换掉
 */
public class MyRealm extends AuthorizingRealm {

    private DhUsersService dhUsersService;

    public DhUsersService getDhUsersService() {
        return dhUsersService;
    }

    public void setDhUsersService(DhUsersService dhUsersService) {
        this.dhUsersService = dhUsersService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String uname = token.getPrincipal().toString();
        System.out.println(uname);
        Users users = dhUsersService.qureyByName(uname);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                users.getUnickname(),
                users.getUpassword(),
                this.getName()
        );
        return  authenticationInfo;
    }
}
