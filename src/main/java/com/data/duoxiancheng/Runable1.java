package com.data.duoxiancheng;

/**
 * 如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
 * 没有Thread单继承局限性
 * 1）：适合多个相同的程序代码的线程去处理同一个资源
 *
 * 2）：可以避免java中的单继承的限制
 *
 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 *
 * 4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
 */
public class Runable1 implements Runnable {

    private String name;
    public Runable1(String name){
        this.name=name;
    }

    @Override
    public void run() {
      for(int i=0;i<10;i++)
          try {
          Thread.sleep(1000);
          System.out.println(name +"--i");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread1("线程A")).start();
        new Thread(new Thread1("线程B")).start();
        new Thread(new Thread1("线程C")).start();
        String name="线程1";
        //匿名内部类的多线程
  /*      new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                    System.out.println(name +"--"+i);
            }
        }).start();*/

        //lamab
      /*  new Thread(()->{
                for(int i=0;i<10;i++)
                    System.out.println(name +"--"+i);
        }).start();*/
    }
}
