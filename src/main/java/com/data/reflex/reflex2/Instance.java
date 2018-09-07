package com.data.reflex.reflex2;


import java.util.Date;

/**
 * @Auther: ljh
 * @Date: 2018/9/6 14:43
 * @Description:
 */
public class Instance {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName("java.util.Date");

        Date date  = (Date) cls.newInstance();

        System.out.println(date);


        Class<?> cls2 = Class.forName("com.data.reflex.reflex2.Penson");
        Penson penson = (Penson) cls2.newInstance();
        System.out.println(penson);
    }
}

class Penson {
    public Penson(){
        System.out.println("新的对象已经实例化");
    }

    @Override
    public String toString() {
        return "是个人";
    }
}
