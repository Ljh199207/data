package com.data.mode.cor.handle;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 16:19
 * @Description:
 */
public class Director extends  PriceHandler {




    @Override
    public void disconut(float discout) {

     if(discout<=0.5){
         System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discout);
     }else {
         successor.disconut(discout);
     }

    }
}
