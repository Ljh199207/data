package com.data.mode.template;

/**
 * @Auther: ljh
 * @Date: 2018/11/6 15:32
 * @Description:
 */
public class Tea extends  RefreshBevera {
    @Override
    protected void brew() {
        System.out.println("用80度的水来冲泡茶叶！");
    }

    @Override
    protected void addCandiments() {
        System.out.println("加入一堆其他茶叶！");
    }

    @Override
    protected boolean isCustomerAddCandiments() {
        return  false;
    }
}
