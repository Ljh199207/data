package com.data.mode.command.command2;

/**
 * @Auther: ljh
 * @Date: 2019/1/31 10:18
 * @Description:
 */
public class Invoker {
    Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    //
    public void excuteCommmand(){
        command.excute();
    }

    public void undoCommand(){
        command.undo();
    }
}
