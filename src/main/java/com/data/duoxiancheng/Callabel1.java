package com.data.duoxiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Callable 接口类似于 Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。但是 Runnable 不会返回结果，并且无法抛出经过检查的异常。
 *
 * Executors 类包含一些从其他普通形式转换成 Callable 类的实用方法。
 *
 * call方法相当于run 方法
 */

public class Callabel1 implements Callable<String> {

    private int ticket = 5;
    @Override
    public String call() {
        for(int i=0;i<20;i++)
            if(ticket>0)
                System.out.println("卖票数"+this.ticket--);

        return "票卖完了！";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> cal  = new Callabel1();
        FutureTask<String> futureTask = new FutureTask(cal);

        Thread thread= new Thread(futureTask);
        Thread thread2= new Thread(futureTask);

        thread.start();
        thread2.start();
        System.out.println(futureTask.get());

    }
}
