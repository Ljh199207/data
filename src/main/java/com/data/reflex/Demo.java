package com.data.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
 * 通过反射越过泛型检查
 *
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
*/
public class Demo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        Class listClass = list.getClass(); //得到 strList 对象的字节码 对象
        //获取add()方法

        Method m = listClass.getMethod("add", Object.class);
        m.invoke(list, 100);
        //遍历集合
        for(Object obj : list){
            System.out.println(obj);
        }

    }








}
