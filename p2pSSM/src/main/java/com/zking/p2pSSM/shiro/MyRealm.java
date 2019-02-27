package com.zking.p2pSSM.shiro;

import com.zking.p2pSSM.model.dh.Users;
import com.zking.p2pSSM.service.dh.UsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 14:15
 *
 *  该类realm定义的作用是为了将 shiro的ini文件替换掉
 */
public class MyRealm extends AuthorizingRealm {

    private UsersService usersService;

    public UsersService getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String unickname = token.getPrincipal().toString();
        Users users = usersService.qureyByName(unickname);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                users.getUnickname(),
                users.getUpassword(),
                this.getName()
        );
        return authenticationInfo;
    }
}
