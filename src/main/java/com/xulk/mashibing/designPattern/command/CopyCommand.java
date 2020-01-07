package com.xulk.mashibing.designPattern.command;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 02:42
 **/
public class CopyCommand extends Command {

    Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    public void doit() {
        content.msg = content.msg+content.msg;
    }

    @Override
    public void undo() {
        content.msg = content.msg.substring(0,content.msg.length()/2);
    }
}
