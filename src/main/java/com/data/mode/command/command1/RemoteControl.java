package com.data.mode.command.command1;

import com.data.mode.command.Command;

/**
 * @Auther: ljh
 * @Date: 2019/1/24 10:29
 * @Description:
 */
public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    public  void setCommand(int solt ,Command onCommand,Command offCommand){
        onCommands[solt] = onCommand;
        offCommands[solt]=offCommand;
    }

    public  void onbuttonWasPress(int solt){
        onCommands[solt].excute();
    }

    public  void offbuttonWasPress(int solt){
        offCommands[solt].excute();
    }


    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-------Remote Control--------\n");
        for(int i=0;i<onCommands.length;i++){
            stringBuffer.append("[solt "+i+"]"+onCommands[i].getClass().getName());
        }
        return super.toString();
    }
}
