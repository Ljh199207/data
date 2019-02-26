package com.data.mode.command.command2;

/**
 * @Auther: ljh
 * @Date: 2019/1/31 10:23
 * @Description:
 */
public class Client {


    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.excuteCommmand();
        invoker.undoCommand();
    }
}
