package com.data.basejava.String;

/**
 *  Runtime 类 在java 进程中都会存在一个Runtime类的存在
 *  由于Runtime类在设计时只提供一个唯一的实例，构造方法被私有化了
 *
 *
 *  java 中内存的划分  中两个部分
 *  1.堆内存  ：保存实例化内容 在每一个jvm进程之中,对象堆内存主要是垃圾回收问题
 *  2.非堆内存 ：（Eden +frontSpace +toSpace)  主要用于产生新对象
 *  所有方法全局方法区，所有static的全局数据区
 *  永生代，负责是存放反射对象的操作空间
 *
 *   垃圾回收
 *  新的对象保存在Eden中 ，之后此对象保存在年轻代中（从 GC MinorGc），而后gc之后保存在年轻代对象，将保存在旧生代(主GC ,majorGC)中
 *  如果再有新的对象，从年轻代回收，再找到旧生代回收，最后都没空间，全扫描、
 *
 *  如果调整内存空间 只能调整堆内存的大小 它的调整主要有3个参数
 *  1."-Xms" :初始分配大小  为物理内存的64分之一，最多不超过1G;
 *  2."-Xmx" :最大分配内存  为物理空间的4分之一，
 *  3."-Xmn" ：年轻代的堆内存大小空间
 *  -Xms1024M -Xmx1024M -Xmn512M
 */

public class TestRuntime {

    public static void main(String[] args) {
        //取得Runtime 类
        Runtime runtime = Runtime.getRuntime();
        //获取内存
        long free = runtime.freeMemory();
        System.out.println("1,free "+ runtime.freeMemory());
        System.out.println("1,Max "+runtime.maxMemory());
        System.out.println("1,total "+runtime.totalMemory());

        String str = "";
        for (int i = 0; i <3000 ; i++) {
            str+=i;
        }
        System.out.println("2,free "+ runtime.freeMemory());
        System.out.println("2,Max "+runtime.maxMemory());
        System.out.println("2,total "+runtime.totalMemory());

        runtime.gc();

        System.out.println("3,free "+ runtime.freeMemory());
        System.out.println("3,Max "+runtime.maxMemory());
        System.out.println("3,total "+runtime.totalMemory());
    }

}
