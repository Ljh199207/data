package com.data.duoxiancheng.cousmer;

public class Productor implements Runnable {

    private Info info =null;
    public  Productor(Info info){
        this.info = info;
    }

    @Override
    public void run() {
       for (int i =0;i<50;i++){
           if(i%2==0) //偶数
           {
               /*this.info.setTitle("这是A");
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               this.info.setContent("这就是A");*/

               this.info.set("这是A","这就是A");
           }
           else {
             /*  this.info.setTitle("这是B");
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               this.info.setContent("这就是B");*/
               this.info.set("这是B","这就是B");
           }
       }
    }
}
