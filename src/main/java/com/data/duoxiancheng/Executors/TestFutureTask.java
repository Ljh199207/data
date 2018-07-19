package com.data.duoxiancheng.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureTask {

    public static void main(String[] args) throws Exception {

        System.out.println("main Thread begin at:"+ System.nanoTime());

        //直接通过New Thread来启动线程

      /*  HandleCallable task1 = new HandleCallable("1");
        FutureTask<Integer> result1 = new FutureTask<Integer>(task1);
        Thread thread1 = new Thread(result1);
        thread1.start();

        HandleCallable task2 = new HandleCallable("2");
        FutureTask<Integer> result2 = new FutureTask<Integer>(task2);
        Thread thread2 = new Thread(result2);
        thread2.start();*/

        //通过线程池来启动线程

        ExecutorService executor = Executors.newCachedThreadPool();
        HandleCallable task1 = new HandleCallable("1");
        HandleCallable task2 = new HandleCallable("2");

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);
        executor.shutdown();

        Thread.sleep(1000);
        System.out.println("task1返回结果:"  + result1.get());
        System.out.println("task2返回结果:"  + result2.get());

        System.out.println("main Thread finish at:"+ System.nanoTime());

    }
}
