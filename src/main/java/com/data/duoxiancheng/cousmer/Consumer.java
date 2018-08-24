package com.data.duoxiancheng.cousmer;

public class Consumer implements Runnable {
    private Info info;
    public  Consumer(Info info){
        this.info=info;
    }

    @Override
    public void run() {
     for (int i=0;i<50;i++)
     {
     /*    try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(this.info.getContent() +"---"+this.info.getTitle());*/
     this.info.get();
     }
    }
}
