package com.data.mode.template;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 15:08
 * @Description:
 */
public  abstract class RefreshBevera {

    /**
     *
     * 功能描述: 制作模版方法
     * 封装了子类所有的共同遵循的算法框架
     *
     */
    public final void  preparBeverageTemplage(){

        //将水煮沸
        boilWater();
        //泡制饮料
        brew();
        //倒入杯中
        pourInCups();
        //加入调味
        if(isCustomerAddCandiments()){
            addCandiments();
        }
    }

    protected boolean isCustomerAddCandiments() {
        return  true;
    }

    private void boilWater() {
        System.out.println("将水煮沸！");
    }
    //泡制饮料
    protected abstract void brew() ;

    private void pourInCups() {
        System.out.println("倒入杯中！");
    }

    protected abstract void addCandiments() ;
}
