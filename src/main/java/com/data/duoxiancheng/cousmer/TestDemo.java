package com.data.duoxiancheng.cousmer;

public class TestDemo {
    public static void main(String[] args) {
        //1.数据错乱！！！！
        //2.重复生产，重复取出
        Info info = new Info();
        Productor productor = new Productor(info);
        Consumer consumer = new Consumer(info);
        new Thread(productor).start();
        new Thread(consumer).start();
    }
}
