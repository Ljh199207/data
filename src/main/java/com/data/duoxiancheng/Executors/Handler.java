package com.data.duoxiancheng.Executors;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *   功能概要：缓冲线程池实例-execute运行
 */
public class Handler implements Runnable {

    //创建线程池
    ExecutorService executorService = Executors.newCachedThreadPool();
    //获取当前系统的CPU 数目
    int cpuNums = Runtime.getRuntime().availableProcessors();

    ExecutorService executorService2 =Executors.newFixedThreadPool(cpuNums * 10); //ExecutorService通常根据系统资源情况灵活定义线程池大小



    private String name ;
    public Handler(String name) {
        this.name = "thread"+name;
    }


    @Override
    public void run() {
        System.out.println( name +" Start. Time = "+new Date());
        processCommand();
        System.out.println( name +" End. Time = "+new Date());
    }

    private void processCommand()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * CachedThreadPool
     */

    public static  void  testCachedThreadPool(){
        System.out.println("Main: Starting at: "+ new Date());

        ExecutorService exec = Executors.newCachedThreadPool();   //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        for(int i = 0; i < 100; i++) {
            exec.execute(new Handler(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());

    }

    /**
     * testFixedThreadPool
     * FixedThreadPool模式会使用一个优先固定数目的线程来处理若干数目的任务。规定数目的线程处理所有任务，
     * 一旦有线程处理完了任务就会被用来处理新的任务(如果有的话)。这种模式与上面的CachedThreadPool是不同的，
     * CachedThreadPool模式下处理一定数量的任务的线程数目是不确定的。而FixedThreadPool模式下最多 的线程数目是一定的。
     */

    public static  void testFixedThreadPool (){
        System.out.println("Main Thread: Starting at: "+ new Date());
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 100; i++) {
            exec.execute(new Handler(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
    }

    /**
     *  等价于 ExecutorService exec = Executors.newFixedThreadPool(1);
     *  其实这个就是创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，
     *  并且能保证一条线程执行完成后才开启另一条新的线程
     */
    public static  void testSingleThreadExecutor(){
        System.out.println("Main Thread: Starting at: "+ new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++) {
            exec.execute(new Handler(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
    }

    /**
     * 这是一个计划线程池类，它能设置线程执行的先后间隔及执行时间等，功能比上面的三个强大了一些。
     */
    public static  void testScheduledThreadPool()
    {
        System.out.println("Main Thread: Starting at: "+ new Date());
        ScheduledThreadPoolExecutor exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);   //创建大小为10的线程池
        for(int i = 0; i < 100; i++) {
            exec.schedule(new Handler(String.valueOf(i)),10,TimeUnit.SECONDS);
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        while (!exec.isTerminated())
        {
            //wait for all tasks to finish

        }
        System.out.println("Main: Finished all threads at"+ new Date());
    }




    public static void main(String[] args) {
       // testCachedThreadPool();
       //  testFixedThreadPool();
        //testSingleThreadExecutor();
        testScheduledThreadPool();
    }
}

