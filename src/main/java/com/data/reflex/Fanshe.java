package com.data.reflex;

public class Fanshe {

    // Object ——> getClass();
    //任何数据类型（包括基本数据类型）都有一个“静态”的class属性
    // 通过Class类的静态方法：forName（String  className）(常用)
    public static void main(String[] args) {

        //第一种方式获取Class对象
        Student stu1 = new Student();
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("com.data.reflex.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //三种方式常用第三种，
    // 第一种对象都有了还要反射干什么。
    // 第二种需要导入类的包，依赖太强，不导包就抛编译错误。
    // 一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
}
