package com.data.duoxiancheng.Executors;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyHandle implements Runnable {

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 初始化延迟0ms开始执行，
     * 每隔2000ms重新执行一次任务
     * <p>
     * 间隔指的是连续两次任务开始执行的间隔。对于scheduleAtFixedRate方法，
     * 当执行任务的时间大于我们指定的间隔时间时，它并不会在指定间隔时开辟一个新的线程并发执行这个任务。而是等待该线程执行完毕。
     * 如果上次的线程还没有执行完成，那么会阻塞下一个线程的执行。即使线程池设置得足够大。
     */
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleAtFixedRate(new MyHandle(), 0, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     * 按指定频率间隔执行某个任务
     * 间隔指的是连续上次执行完成和下次开始执行之间的间隔。
     */
    public static void executeFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleWithFixedDelay(new MyHandle(), 0, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     * 周期定时执行某个任务
     * 每天晚上9点执行一次
     * 每天定时安排任务进行执行
     */
    public static void executeEightAtNightPerDay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("21:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        executor.scheduleAtFixedRate(new MyHandle(),initDelay,oneDay,TimeUnit.MILLISECONDS);

    }
    private static long getTimeMillis(String time) {
        try {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
        Date curDate = dateFormat.parse(dayFormat.format(new Date())+" "+time);
        return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

        public static void main(String[] args) {
        //executeFixedRate();
        //executeFixedDelay();
            executeEightAtNightPerDay();
    }
}
