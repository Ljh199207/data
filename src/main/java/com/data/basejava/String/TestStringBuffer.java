package com.data.basejava.String;

/**
 * StirngBuffer 类 与String
 */
public class TestStringBuffer {

    public static void main(String[] args) {
        String str = "Hello" +" world!";
        //利用 StringBuffer 类的构造方法 StringBuffer(String str)
        StringBuffer stringBuffer = new StringBuffer(str);
        //StringBuffer 变成 String
        //1.toString 方法
        //2.利用 "+"可以所有类型变成String类型；

        //在指定位置插入内容

        stringBuffer.insert(0,"你好！").insert(1,"特么");
        System.out.println(stringBuffer);
        stringBuffer.reverse();

        //反转 public StringBuffer reverse()
        System.out.println(stringBuffer);


        /**
         *         StringBuffer 与 StringBuilder
         *         1.StringBuffer  线程安全    性能不高
         *         2.StringBuilder 线程不安全  性能高
         */



    }

}
