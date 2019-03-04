package com.zking.p2pSSM.shiro;

import com.zking.p2pSSM.model.Employee;
import com.zking.p2pSSM.service.wha.WhaEmployeeService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * @author Giraffe Wld
 * @site www.grf.com
 * @company grf公司
 * @create  2019-02-19 14:15
 *
 *  该类realm定义的作用是为了将 shiro的ini文件替换掉
 */
public class WhaMyRealm extends AuthorizingRealm {
    private WhaEmployeeService whaEmployeeService;

    public WhaEmployeeService getWhaEmployeeService() {
        return whaEmployeeService;
    }

    public void setWhaEmployeeService(WhaEmployeeService whaEmployeeService) {
        this.whaEmployeeService = whaEmployeeService;
    }

    /**
     * shiro授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String userName = principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles= whaEmployeeService.queryRolesByEmpName(userName);
//        System.out.println("角色："+roles.toString());
        Set<String> perms= whaEmployeeService.queryPermssByEmpName(userName);
//        System.out.println("菜单id:"+perms.toString());
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }
    /**
     * shiro认证方法
     * @param token  该token令牌是从controller层传递过来的
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();//获取用户名
//        String password = token.getCredentials().toString();//获取用户密码
        Employee employee = this.whaEmployeeService.selectByPrimaryKeyename(username);// 从数据库获取对应用户名的用户
//        System.out.println(employee.toString());
        if (employee == null) {
            throw new AccountException("不存在此用户");
        }
        ByteSource salt = ByteSource.Util.bytes(employee.getEsalt());
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                employee.getEname(), employee.getEpassword(), salt,this.getName()
        );
        return authenticationInfo;
    }
}
