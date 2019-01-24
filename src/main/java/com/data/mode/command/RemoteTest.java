package com.data.mode.command;

import com.data.mode.command.bean.GarageDoor;
import com.data.mode.command.bean.Light;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 09:18
 * @Description:
 */
public class RemoteTest {

    public static void main(String[] args) {

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPress();

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpenCommand  = new GarageDoorOpenCommand(garageDoor);
        simpleRemoteControl.setCommand(garageDoorOpenCommand);
        simpleRemoteControl.buttonWasPress();


    }
}
