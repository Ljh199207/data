package com.data.duoxiancheng;

public class Synchronized implements  Runnable {

    private int ticket = 5;
    @Override
    public void run() {
        for(int i=0;i<20;i++)
            synchronized (this){
                if(ticket>0){
                    try {
                        Thread.sleep(1000);
                        System.out.println("卖票数"+this.ticket--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
    }

    public static void main(String[] args) {
        Synchronized s1 = new Synchronized();
        Thread t1 = new Thread(s1,"线程A");
        Thread t2 = new Thread(s1,"线程B");
        Thread t3 = new Thread(s1,"线程C");
        t1.start();t2.start();t3.start();
    }
}
