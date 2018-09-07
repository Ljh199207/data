package com.data.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ljh
 * @Date: 2018/9/7 11:43
 * @Description:
 */
public class LambdaDemo {



    public static void main(String[] args) {



     /*   new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();*/


        new Thread(
                () -> System.out.println("Hello world!")
        ).start();


    //   lambddaSet();
        lambdaMap();
    }


    public static void lambddaSet(){
        List<String> languages = Arrays.asList("java","scala","python");
        languages.forEach(x-> System.out.println(x));
        languages.forEach(System.out::println);

    }

    public  static void lambdaMap(){

        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x->x+x*0.05).forEach(x-> System.out.println(x));
    }




}
