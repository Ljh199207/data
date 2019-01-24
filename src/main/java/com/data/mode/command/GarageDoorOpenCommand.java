package com.data.mode.command;

import com.data.mode.command.bean.GarageDoor;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 09:40
 * @Description:
 */
public class GarageDoorOpenCommand implements  Command {

    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void excute() {
        garageDoor.up();
    }
}
