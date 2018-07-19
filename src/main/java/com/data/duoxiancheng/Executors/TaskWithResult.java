package com.data.duoxiancheng.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 功能概要：缓冲线程池实例-submit运行
 * 3、shutdown()
 *
 * 通常放在execute后面。如果调用 了这个方法，一方面，表明当前线程池已不再接收新添加的线程，
 * 新添加的线程会被拒绝执行。另一方面，表明当所有线程执行完毕时，回收线程池的资源。注意，它不会马上关闭线程池！
 *
 * 4、shutdownNow()
 *
 * 不管当前有没有线程在执行，马上关闭线程池！这个方法要小心使用，要不可能会引起系统数据异常！
 */
public class TaskWithResult implements Callable {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public Object call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        //一个模拟耗时的操作
        for (int i = 999999; i > 0; i--) ;
        return"call()方法被自动调用，任务的结果是：" + id + "    " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));
            //将任务执行结果存储到List中
            resultList.add(future);
        }
        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
        executorService.shutdown();
//遍历任务的结果
        for (Future<String> fs : resultList) {
            try {
                System.out.println(fs.get());     //打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {

            }
        }

    }
}


