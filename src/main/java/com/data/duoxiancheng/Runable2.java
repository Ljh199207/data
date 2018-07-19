package com.data.duoxiancheng;

public class Runable2 implements  Runnable {
    @Override
    public void run() {
        System.out.println("Thread"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runable2 r2 = new Runable2();

        new Thread(r2,"这个名字").start();

        new Thread(r2).start(); //线程启动调用run方法;

        r2.run();  //直接通过对象启动run方法;
    }
}
