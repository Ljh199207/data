package com.data.mode.singleton;

/**
 * @Auther: ljh
 * @Date: 2019/1/22 15:30
 * @Description: 使用“双重加锁” 在getInstance 中减少使用同步
 */
public class Singleton4 {

    private Singleton4(){

    }


    private volatile static  Singleton4 singleton4;

    public static Singleton4 getSingleton4(){
        if(singleton4 ==null){
            synchronized (Singleton4.class){
                if(singleton4 ==null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return  singleton4;
    }

}
