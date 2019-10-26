package com.xulk.designPattern.mashibing.command;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 02:50
 **/
public class Main {

    public static void main(String[] args) {
        Content content = new Content();

        AddCommand addCommand = new AddCommand(content);
        addCommand.doit();
        addCommand.undo();

        CopyCommand copyCommand = new CopyCommand(content);
        copyCommand.doit();
        copyCommand.undo();

        System.out.println(content.msg);


    }
}
