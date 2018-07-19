package com.data.duoxiancheng;


 class QingDao{
    public synchronized  void say(YouQianRen yqr){
        System.out.println("强盗说：给我300万美金，还给你儿子");
        yqr.get();
    }
    public synchronized  void get()
    {
        System.out.println("强盗得到300万美金，孩子放了");

    }
        }
class YouQianRen{
    public synchronized  void say(QingDao qd){
        System.out.println("富人说：先放我儿子，我再给你300万美金");
        qd.get();
    }

    public synchronized  void get()
    {
        System.out.println("富人说：先放我儿子，我再给你300万美金");
    }
}

public class SisuoDemo implements Runnable {
    private QingDao qd = new QingDao();
    private YouQianRen yqr =new YouQianRen();
    public SisuoDemo()
    {
        new Thread(this).start();
        yqr.say(qd);
    }
    public static void main(String[] args) {
      new SisuoDemo();
    }

    @Override
    public void run() {
        qd.say(yqr);
    }
}
