package com.data.mode.command;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 09:15
 * @Description:
 */
public class SimpleRemoteControl {

    Command solt;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command){
        solt = command;
    }

    public  void buttonWasPress(){
        solt.excute();
    }

}
