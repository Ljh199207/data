package com.data.mode.duck;

import com.data.mode.duck.fly.FlyBehavior;
import com.data.mode.duck.quack.QuackBehavior;

/**
 * @Auther: ljh
 * @Date: 2019/1/14 14:57
 * @Description:
 */
public abstract class Duck {

     FlyBehavior flyBehavior;
     QuackBehavior quackBehavior;

     public Duck(){

    }

    public  abstract  void display();

     public void perfomFly(){
         flyBehavior.fly();
     }

     public void performQuack(){
         quackBehavior.quack();
     }

     public  void swim(){

         System.out.println("这只鸭子会游泳");
     }


    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
