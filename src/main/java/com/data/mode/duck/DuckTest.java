package com.data.mode.duck;

import com.data.mode.duck.fly.FlyRocketPowered;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 15:14
 * @Description:
 */
public class DuckTest {

    public static void main(String[] args) {
       /* MallarDuck mallarDuck = new MallarDuck();
        mallarDuck.perfomFly();
        mallarDuck.performQuack();*/
        ModleDuck modleDuck = new ModleDuck();
        modleDuck.perfomFly();
        modleDuck.setFlyBehavior(new FlyRocketPowered());
        modleDuck.perfomFly();
    }
}
