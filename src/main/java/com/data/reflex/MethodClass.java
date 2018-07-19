package com.data.reflex;

import java.lang.reflect.Method;

/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
):
 */
public class MethodClass {

    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class aClass = Class.forName("com.data.reflex.Student");
        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");

        Method[] methods= aClass.getMethods();
        for (Method method :methods)
            System.out.println(method);
        System.out.println("***************获取所有的方法，包括私有的*******************");
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method method:methods1)
            System.out.println(method);
        System.out.println("***************获取公有的show1()方法*******************");
        Method method = aClass.getMethod("show1", String.class);
        System.out.println(method);
        //实例化一个Student对象
        Object obj = aClass.getConstructor().newInstance();
        method.invoke(obj,"ABC");
        System.out.println("***************获取私有的show4()方法******************");
        Method method1 = aClass.getDeclaredMethod("show4", int.class);
        System.out.println(method1);
        method1.setAccessible(true);//解除私有限定
        Object result = method1.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);

        Method mains = aClass.getMethod("main",String[].class);//第一个参数：方法名称，第二个参数：方法形参的类型
        //3、调用main方法
        // methodMain.invoke(null, new String[]{"a","b","c"});
        //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
        //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
        mains.invoke(null, (Object)new String[]{"a","b","c"});//方式一
        // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二
    }
}
