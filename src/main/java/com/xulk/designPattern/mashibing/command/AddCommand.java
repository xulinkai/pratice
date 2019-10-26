package com.xulk.designPattern.mashibing.command;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 02:35
 **/
public class AddCommand extends Command {

    Content content;

    String addMsg = "I am xulinkai";

    public AddCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doit() {
        content.msg = content.msg+addMsg;
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0,content.msg.length()-addMsg.length());
    }
}
