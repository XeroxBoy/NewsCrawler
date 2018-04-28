package com.invest.realm;

import com.invest.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.invest.service.*;

import java.util.HashSet;
import java.util.Set;

public class shiroRealm extends AuthorizingRealm{
    @Autowired
    private userService userService;
    //登陆成功的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info= new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        roles.add("user");
        if(principalCollection.equals("admin")) roles.add("admin");
        info.setRoles(roles);
    info.setStringPermissions(roles);
        return info;
    }
    //验证当前登录用户
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        User user = userService.selectUser(username);

        if(user!=null)
        {
            AuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"realm");
            return info;
        }
        else{return null;}
    }
}

