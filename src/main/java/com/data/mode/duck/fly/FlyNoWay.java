package com.data.mode.duck.fly;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 14:53
 * @Description:
 */
public class FlyNoWay implements  FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm not flying ");
    }
}
