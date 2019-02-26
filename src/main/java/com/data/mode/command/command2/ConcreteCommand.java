package com.data.mode.command.command2;

/**
 * @Auther: ljh
 * @Date: 2019/1/31 10:13
 * @Description:
 */
public class ConcreteCommand implements  Command {
    Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.action();
    }

    @Override
    public void undo() {
        receiver.unaction();
    }
}
