package com.data.mode.duck;

import com.data.mode.duck.fly.FlyNoWay;
import com.data.mode.duck.quack.Quack;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 15:32
 * @Description:
 */
public class ModleDuck extends Duck {


    public ModleDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }


    @Override
    public void display() {

    }
}
