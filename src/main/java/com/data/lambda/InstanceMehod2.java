package com.data.lambda;

import com.data.duoxiancheng.Runable1;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Auther: ljh
 * @Date: 2018/9/12 11:09
 * @Description:  对象方法引用
 *  语法
 *  类名：：instMethod
 */
public class InstanceMehod2 {

  /**
   *
   * 功能描述:  这些方法没有输入参数 ，不能使用对象方法引用
   *
   */
     public  void not(){
         Runnable r1 =  ()-> {};
         Closeable c1 =()->{};
         Supplier<String> s = ()->"";
     }


    public static void main(String[] args) {

         //抽象方法的第一个参数类型刚好是实例方法的类型
        Consumer<Too> c1 = (Too too) ->new Too().foo();
        Consumer<Too> c2 = Too::foo;
        c1.accept(new Too());
        c2.accept(new Too());

        // 抽象方法剩余参数恰好可以当做实例方法的参数


        BiConsumer<Too ,String > b = ((too, s) ->new Too().fo(s) );
        BiConsumer<Too ,String > b1 = Too::fo;
        b1.accept(new Too(),"Abc");
        b.accept(new Too(),"Abcdddd");
    }
}

class  Too{
    public  void foo(){
        System.out.println("invoke");
    }

    public  void fo(String str){
        System.out.println(str);
    }

}