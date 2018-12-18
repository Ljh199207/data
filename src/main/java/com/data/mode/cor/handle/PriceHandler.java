package com.data.mode.cor.handle;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 16:15
 * @Description:
 */
public abstract class PriceHandler {

    protected  PriceHandler successor;

    //直接后继，用于后续请求
    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }

    public   abstract  void  disconut(float discout);

    public  static  PriceHandler createPriceHandler(){
        PriceHandler sale = new Sales();
        PriceHandler man =  new Managers();
        PriceHandler dir = new Director();
        PriceHandler vp = new VicePresident();
        PriceHandler Ceo = new Ceo();
        sale.setSuccessor(man);
        man.setSuccessor(dir);
        dir.setSuccessor(vp);
        vp.setSuccessor(Ceo);
        return  sale;
    }
}
