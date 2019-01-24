package com.data.mode.duck.fly;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 14:51
 * @Description:
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
