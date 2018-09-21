package com.data.local;

import java.util.ResourceBundle;

/**
 * @Auther: ljh
 * @Date: 2018/9/20 09:33
 * @Description:
 */
public class ResourcesBundleTest {


    public static void main(String[] args) {
        //设置资源文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("local.Message");
        System.out.println(resourceBundle.getString("welcome.info"));
    }
}
