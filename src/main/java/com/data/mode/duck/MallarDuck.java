package com.data.mode.duck;

import com.data.mode.duck.Duck;
import com.data.mode.duck.fly.FlyWithWings;
import com.data.mode.duck.quack.Quack;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 15:11
 * @Description:
 */
public class MallarDuck extends Duck {



    public MallarDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }



    @Override
    public void display() {
        System.out.println("It's a relly MallarDuck!");
    }


}
