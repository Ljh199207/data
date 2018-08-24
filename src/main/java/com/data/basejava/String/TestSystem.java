package com.data.basejava.String;

public class TestSystem {


    public static class  penson{
        public penson()
        {
            System.out.println("这是个测试");
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("测试回收而已");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //定义时间多少

      /*  long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("花费时间"+(start-end));*/


        penson pen =new  penson();

        pen = null;

       System.gc();

    }
    /**
     *   在对象实例化的时候可以利用构造方法进行相应的处理操作，但是在某一个对象回收前给他一些处理的机会呢？在
     *   Object 类中提供有一个对象加收前的的释放操作
     *   protected void finalizc() throws Throwable ;
     */




}
