package com.data.duoxiancheng;

public class Thread_or_Runable implements Runnable    {

    private int ticket = 5;

    @Override
    public void run() {
        for(int i=0;i<20;i++)
            if(ticket>0)
            System.out.println("卖票数"+this.ticket--);
    }

    public static void main(String[] args) {
        Thread_or_Runable thread_or_runable1 = new Thread_or_Runable();
        /*Thread_or_Runable thread_or_runable2 = new Thread_or_Runable();
        Thread_or_Runable thread_or_runable3 = new Thread_or_Runable();
        thread_or_runable1.start();
        thread_or_runable2.start();
        thread_or_runable3.start();*/
        new Thread(thread_or_runable1).start();
        new Thread(thread_or_runable1).start();
        new Thread(thread_or_runable1).start();
    }




}
