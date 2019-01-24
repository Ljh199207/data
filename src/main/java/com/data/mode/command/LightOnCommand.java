package com.data.mode.command;

import com.data.mode.command.bean.Light;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 09:10
 * @Description:
 */
public class LightOnCommand implements  Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }
}
