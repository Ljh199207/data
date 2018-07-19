package com.data.duoxiancheng.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestCompletSerivce {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTest();
        CompleTest();
    }

    /**
     * 从输出结果可以看出,我们只能一个一个阻塞的取出。
     * 这中间肯定会浪费一定的时间在等待上。如7返回了。
     * 但是前面1-6都没有返回。那么7就得等1-6输出才能输出
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void FutureTest() throws InterruptedException, ExecutionException {
        System.out.println("main Thread begin:");
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> result = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submit = executor.submit(new HandleFuture(i));
            result.add(submit);
        }
        executor.shutdown();
        for (int i = 0; i < 10; i++) {//一个一个等待返回结果
            System.out.println("返回结果：" + result.get(i).get());
        }
        System.out.println("main Thread end:");
    }

    /**
     * 结果的输出和线程的放入顺序无关系。
     * 每一个线程执行成功后，立刻就输出。
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void CompleTest() throws InterruptedException, ExecutionException {
        System.out.println("main Thread begin:");
        ExecutorService executor = Executors.newCachedThreadPool();
        // 构建完成服务
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
        for (int i = 0;i<10;i++) {
            completionService.submit(new HandleFuture(i));
        }
        for (int i = 0;i<10;i++) {//一个一个等待返回结果
            System.out.println("返回结果："+completionService.take().get());
        }
        System.out.println("main Thread end:");

    }

}
