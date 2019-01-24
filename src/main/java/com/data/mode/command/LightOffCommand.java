package com.data.mode.command;

import com.data.mode.command.bean.Light;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 09:10
 * @Description:
 */
public class LightOffCommand implements  Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.off();
    }
}
