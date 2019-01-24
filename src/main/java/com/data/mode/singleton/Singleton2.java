package com.data.mode.singleton;

/**
 * @Auther: ljh
 * @Date: 2019/1/22 15:11
 * @Description:  单例一般在创建才需要同步，synchronized  加在方法上每次创建就是负担，不是最理想的  singleton3 在方法里面同步
 */
public class Singleton2 {

    private Singleton2(){}
    private static  Singleton2 singleton2;
    public  static  synchronized Singleton2 getSingleton2(){
        if(singleton2==null){
            singleton2 = new Singleton2();

        }
        return singleton2;
    }

}
