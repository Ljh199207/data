package com.data.mode.cor;

import com.data.mode.cor.handle.PriceHandler;

import java.util.Random;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 16:41
 * @Description:
 */
public class Custom {

    private PriceHandler priceHandler;

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void requestDistcount(float discout){
        priceHandler.disconut(discout);
    }

   public static  void main(String[] args){
       Custom custom = new Custom();
       custom.setPriceHandler(PriceHandler.createPriceHandler());
       Random random = new Random();

       for (int i = 0; i <=100 ; i++) {
           System.out.print(i+":");
           custom.requestDistcount(random.nextFloat());
       }

   }
}
