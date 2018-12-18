package com.data.mode.cor.handle;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 16:19
 * @Description:
 */
public class Ceo extends PriceHandler {




    @Override
    public void disconut(float discout) {

     if(discout<=0.55){
         System.out.format("%s批准了折扣:%.2f%n",this.getClass().getName(),discout);
     }else {
         System.out.format("%s拒绝了折扣:%.2f%n",this.getClass().getName(),discout);
     }

    }
}
