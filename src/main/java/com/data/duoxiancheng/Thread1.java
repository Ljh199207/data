package com.data.duoxiancheng;

/**
 * Thread 有一个单继承的局限操作
 */
public class Thread1 extends Thread {
    private String name;
    public Thread1(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                //线程的休眠   打断只能是另一个线程来打断
                sleep((int) Math.random() * 10);
            System.out.println(name +"--"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Thread1 thread1 = new Thread1("线程A");
        Thread1 thread2 = new Thread1("线程B");
        Thread1 thread3 = new Thread1("线程C");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        //但是start方法重复调用的话，会出现java.lang.IllegalThreadStateException异常。
     /*   Thread1 thread3 = new Thread1("线程A");
        Thread1 thread4 = thread3;
        thread3.start();
        thread4.start();*/

    }

}
