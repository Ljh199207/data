package com.data.mode.template;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 15:20
 * @Description:
 */
public class Coffee extends  RefreshBevera {

    @Override
    protected void brew() {

        System.out.println("用沸水冲泡咖啡");
    }

    @Override
    protected void addCandiments() {

        System.out.println("加入咖啡的调料");
    }

    @Override
    protected boolean isCustomerAddCandiments() {
        return super.isCustomerAddCandiments();
    }
}
