package com.data.lambda;

import java.util.function.Supplier;

/**
 * @Auther: ljh
 * @Date: 2018/9/12 11:40
 * @Description:  构造方法引用
 * 语法
 * 类名：：new
 */
public class InstanceMethod3 {



    public static void main(String[] args) {

        Supplier <penson> s1 = ()->new penson();
        Supplier <penson> s2 = penson::new;
        s1.get();
        s2.get();
    }

}

class  penson{
    public penson(){
        System.out.println("hello");
    }

    public penson(String a){
        System.out.println(a);
    }
}
