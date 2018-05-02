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
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
       /* MessageDigest md5= null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

        }
        BASE64Encoder base64en = new BASE64Encoder();
        String pass=null;
        //加密后的字符串
        try {
            pass=base64en.encode(md5.digest(user.getPassword().getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {

        }*/
        if(user!=null)
        {
            AuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"realm");
            return info;
        }
        else{return null;}
    }
}

