package com.data.enumpack;

import org.junit.Test;

/**
 * @Auther: ljh
 * @Date: 2019/1/10 10:23
 * @Description:
 */
public class EnumTest {


    @Test
    public void getValue(){
        String name = WechatTradeType.valueOf(24).name();
        System.out.println("获取的值为:"+ name);
    }

    @Test
    public  void getFinal(){
        System.out.println("获取的值为"+WechatTradeType.APP.getValue());
    }





}
