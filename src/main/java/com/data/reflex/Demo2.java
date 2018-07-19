package com.data.reflex;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Demo2 {

    public void test01(Map<String, Student> map, List<Student> list) {
        System.out.println("Demo.test01()");
    }

    public Map<Integer, Student> test02() {
        System.out.println("Demo.test02()");
        return null;
    }


    public static void main(String[] args) throws Exception {

        Class class1 = Class.forName("com.data.reflex.Demo2");
        Method m = class1.getMethod("test01", Map.class, List.class);
        //获得指定方法参数泛型信息
        Type[] t = m.getGenericParameterTypes();
        for (Type type : t) {
            System.out.println(type);
            if (type instanceof ParameterizedType) {
                //获取泛型中的具体信息
                Type[] genericTypes = ((ParameterizedType) type).getActualTypeArguments();
                for (Type genericType : genericTypes) {
                    System.out.println("泛型类型：" + genericType);
                }
            }
        }
        //获得指定方法返回类型泛型
        Method m2 = class1.getMethod("test02", null);
        Type returnType = m2.getGenericReturnType();
        System.out.println(returnType);
        if(returnType instanceof ParameterizedType) {
            Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
            for (Type genericType : genericTypes) {
                System.out.println("返回值，泛型类型："+genericType);
            }
        }


        }
}
