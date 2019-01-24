package com.data.mode.duck.fly;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 15:34
 * @Description:
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with rocket");
    }
}
