package com.data.lambda;

import com.data.duoxiancheng.Runable1;

import java.util.concurrent.Callable;

/**
 * @Auther: ljh
 * @Date: 2018/9/10 09:26
 * @Description:
 */
public class AppLambda {

    public static void main(String[] args) throws Exception {

        //无参无返回值
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        };
        r1.run();

        Runnable r2 =()->{
            System.out.println("run");
        };
        r2.run();

        Runnable r3 = ()-> System.out.println("run");
        r3.run();


        //无参有返回值
        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        };
        Callable<String> c2 =()-> {return  "hello";};

        Callable<String> c3 =() -> "hello";

        System.out.println(c1.call());
        System.out.println(c2.call());

        // ()->
    }
}
