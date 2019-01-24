package com.data.mode.duck.quack;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 15:02
 * @Description:
 */
public class MuteQuack implements  QuackBehavior  {
    @Override
    public void quack() {
        System.out.println("<<slience>>");
    }
}
