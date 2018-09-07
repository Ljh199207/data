package com.data.reflex.reflex1;

import java.util.Date;

/**
 * @Auther: ljh
 * @Date: 2018/9/6 14:34
 * @Description:
 */
public class reflexClass {

    public static void main(String[] args) throws ClassNotFoundException {

        Date date = new Date();

        //必须有实例化对象
        Class<?> cls = date.getClass();
        System.out.println("全名："+cls.getName());
        System.out.println("类名："+cls.getSimpleName());

        Class<?> cls2 = Date.class;
        System.out.println("全名："+cls2.getName());
        System.out.println("类名："+cls2.getSimpleName());

        Class<?> cls3 = Class.forName("java.util.Date");
        System.out.println("全名："+cls3.getName());
        System.out.println("类名："+cls3.getSimpleName());
    }
}
