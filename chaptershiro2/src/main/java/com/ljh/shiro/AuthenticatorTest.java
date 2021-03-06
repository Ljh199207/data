package com.ljh.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.portable.UnknownException;


/**
 * @Auther: ljh
 * @Date: 2018/12/20 14:45
 * @Description:
 */
public class AuthenticatorTest {


    @Test
    public  void  testAllSuccessfulStrategyWithSuccess(){
        login("classpath:shiro-authenticator-all-success.ini");

        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息

        PrincipalCollection principalCollection = subject.getPrincipals();

        Assert.assertEquals(2, principalCollection.asList().size());
    }

    @Test(expected = UnknownException.class)
    public  void  testAllSuccessfulStrategyWithFail(){
        login("classpath:shiro-authenticator-all-fail.ini");

        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息

        PrincipalCollection principalCollection = subject.getPrincipals();

        Assert.assertEquals(2, principalCollection.asList().size());
    }


    @Test
    public void testAtLeastOneStrategy(){
        login("classpath:shiro-authenticator-atLeastOne-success.ini");

        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息

        PrincipalCollection principalCollection = subject.getPrincipals();

        Assert.assertEquals(2, principalCollection.asList().size());
    }

    @Test
    public void testFirstOneSuccessfulStrategyWithSuccess() {
        login("classpath:shiro-authenticator-first-success.ini");
        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了第一个Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(1, principalCollection.asList().size());
    }




    public  void login(String path){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(path);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager =  factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");



        subject.login(token);

    }
    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
}
