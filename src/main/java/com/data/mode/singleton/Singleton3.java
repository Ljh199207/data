package com.data.mode.singleton;

/**
 * @Auther: ljh
 * @Date: 2019/1/22 15:16
 * @Description:     需要“急切”创建实例，而不用延迟加载方法
 */
public class Singleton3 {

    private  Singleton3(){

    }
    //这种方法可以在依赖加载这个类的时候马上马上创建一个实例，可以保证任何一个线程访问静态变量前已创建了实例。

    private  static  Singleton3 singleton3 =  new Singleton3();

    public  static  Singleton3 getSingleton3(){
        return  singleton3;

    }
}
