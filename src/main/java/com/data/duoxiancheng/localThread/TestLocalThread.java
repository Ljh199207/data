package com.data.duoxiancheng.localThread;

import java.sql.DriverManager;

/**
 * @Auther: ljh
 * @Date: 2018/9/25 09:18
 * @Description:
 *
 * ThreadLocal使用场景举例
 *
 */
public class TestLocalThread {

    public final static ThreadLocal<String> RESOURCE = new ThreadLocal<String>();

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();


/*    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            return DriverManager.getConnection(DB_URL);
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }*/



    public static void main(String[] args) throws InterruptedException {


        final TestLocalThread test = new TestLocalThread();

        test.set();

        System.out.println(test.getLong());
        System.out.println(test.getString());


       Thread thread = new Thread(){

           @Override
           public void run() {
               test.set();
               // 当这里调用了set方法，进一步调用了ThreadLocal的set方法是，会将ThreadLocal变量存储到该线程的ThreadLocalMap类型的成员变量threadLocals中，
               // 注意的是这个threadLocals变量是Thread线程的一个变量，而不是ThreadLocal类的变量。
               System.out.println(test.getLong());
               System.out.println(test.getString());


           }
       };
        thread.start();
        thread.join();
        System.out.println(test.getLong());
        System.out.println(test.getString());


    }

    private void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    private  long getLong(){
        return  longLocal.get();
    }

    private  String getString(){
        return  stringLocal.get();
    }
}
