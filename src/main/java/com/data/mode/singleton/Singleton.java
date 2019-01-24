package com.data.mode.singleton;

/**
 * @Auther: ljh
 * @Date: 2019/1/22 14:58
 * @Description:   一般创建单例
 */
public class Singleton {

     private Singleton(){
     }
     private static  Singleton  singleton;
     public  static  Singleton getSingleton(){
         if(singleton ==null){
             singleton = new Singleton();
         }
         return  singleton;
     }

     public  void  set (String  abc){
         System.out.println("abc"+abc);
     }

}
