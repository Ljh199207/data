package com.data.observed;


import java.util.Observable;
import java.util.Observer;

/**
 * @Auther: ljh
 * @Date: 2018/9/20 15:39
 * @Description:
 */
public class Observedt {

    public static void main(String[] args) {

        Houser houser = new Houser(3000000.0);
        HouserObersverObject houserObersverObject = new HouserObersverObject("张三");
        HouserObersverObject houserObersverObject1 = new HouserObersverObject("李三");
        HouserObersverObject houserObersverObject2 = new HouserObersverObject("王五");
        HouserObersverObject houserObersverObject4 = new HouserObersverObject("张6");
        HouserObersverObject houserObersverObject5 = new HouserObersverObject("张7");
        houser.addObserver(houserObersverObject);   //追加观察者
        houser.addObserver(houserObersverObject1);
        houser.addObserver(houserObersverObject2);
        houser.addObserver(houserObersverObject4);
        houser.addObserver(houserObersverObject5);

        houser.setPrice(5000000.0);
    }

}

class Houser extends Observable {
    private Double price;
    public Houser(Double price)
    {
        this.price =price;
    }

    public void setPrice(Double price) {
        if(price>this.price){ //房子上涨有人关注
          super.setChanged();
          super.notifyObservers(price);  //通知所有观察者发生了改变
        }
        this.price = price;
    }
}


class  HouserObersverObject implements Observer{

    private  String name;
    public  HouserObersverObject(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observable"+o.getClass());
        System.out.println("arg"+arg.getClass());


    }
}
