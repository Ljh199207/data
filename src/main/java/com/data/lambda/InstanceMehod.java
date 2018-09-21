package com.data.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: ljh
 * @Date: 2018/9/11 16:37
 * @Description:  实例方法调用
 */
public class InstanceMehod {

    public  String  put(){
        return "hello";
    }

    public void con(int size){
        System.out.println("size"+size);
    }

    public String toUpperCase(String string){
        return  string.toUpperCase();
    }

    public void test(){

        Function<String,String> f4 =this::toUpperCase;
        System.out.println(f4.apply("JavaMe"));
    }

    public static void main(String[] args) {

        Supplier<String> s1 = ()-> new InstanceMehod().put();
        Supplier<String> s2 = ()-> {return new InstanceMehod().put();};
        Supplier<String> s3 = new InstanceMehod()::put;
        System.out.println(s1.get()+"---"+s2.get()+"---"+s3.get());


        Consumer<Integer> c1 = (size)->new InstanceMehod().con(size);
        Consumer<Integer> c2 = new InstanceMehod()::con;
        c2.accept(12);


        Function<String,String> f1 = (str)->new InstanceMehod().toUpperCase(str);

        Function<String,String> f2 =new InstanceMehod()::toUpperCase;
        System.out.println(f2.apply("sting"));

        InstanceMehod instanceMehod = new InstanceMehod();
        instanceMehod.test();

    }
}
