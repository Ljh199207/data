package com.data.mode.command.command2;

/**
 * @Auther: ljh
 * @Date: 2019/1/31 10:12
 * @Description:
 */
public interface Command {
    //执行操作
    public void excute();

    //撤销操作
    public void undo();
}
