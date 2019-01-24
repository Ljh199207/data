package com.ljh.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Auther: ljh
 * @Date: 2018/12/19 15:19
 * @Description:
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }
    //判断此Realm是否支持此Token
    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
       String userName  = (String) token.getPrincipal();
       //得到密码
       String password = new String ((char[])token.getCredentials());

       if(!"zhang".equals(userName)){
           throw new UnknownAccountException(); //如果用户名错误
       }
       if(!"123".equals(password)){
           throw new IncorrectCredentialsException();//如果密码错误
       }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；


        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
