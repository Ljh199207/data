package com.data.duoxiancheng.Executors;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future实例
 * 功能概要
 */
public class TestFuture {


    public static void main(String[] args) throws Exception {

        System.out.println("main Thread begin at:"+ System.nanoTime());
        ExecutorService executor = Executors.newCachedThreadPool();
        HandleCallable task1 = new HandleCallable("1");
        HandleCallable task2 = new HandleCallable("2");
        HandleCallable task3 = new HandleCallable("3");

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        Future<Integer> result3 = executor.submit(task3);

        executor.shutdown();
        Thread.sleep(1000);

        System.out.println("task1运行结果:"+result1.get());
        System.out.println("task2运行结果:"+result2.get());
        System.out.println("task3运行结果:"+result3.get());

        System.out.println("main Thread finish at:"+ System.nanoTime());

    }
}

