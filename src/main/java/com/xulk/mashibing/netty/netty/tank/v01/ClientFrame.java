package com.xulk.mashibing.netty.netty.tank.v01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @description:
 * @author:
 * @create: 2020-01-04 22:59
 **/
public class ClientFrame extends Frame {

    public static final ClientFrame INSTANCE = new ClientFrame();

    TextArea textArea = new TextArea();
    TextField textField = new TextField();

    Client client = null;

    public ClientFrame() {
        this.setSize(600, 400);
        this.setLocation(100, 20);
        this.add(textArea, BorderLayout.CENTER);
        this.add(textField, BorderLayout.SOUTH);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //将字符串发送到服务器
                client.send(textField.getText());
                //textArea.setText(textArea.getText()+textField.getText());
                textField.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //点击x的时候关闭连接，告诉服务器一声我要退出了，然后在退出
                client.closeConnect();
                System.exit(0);
            }
        });
    }

    /**
    * @Description: 连接服务器
    * @Date: 2020/1/5  0:41
    */
    public void connectToServer(){
        client = new Client();
        client.connect();

    }
    public static void main(String[] args) {
        ClientFrame frame = ClientFrame.INSTANCE;
        frame.setVisible(true);
        //客户端界面显示完毕 开始连接服务器
        frame.connectToServer();
        new ClientFrame();
    }

    /**
    * @Description: 客户端获取服务端返回的字符串之后，来执行更新操作
    * @Date: 2020/1/5  0:58
    */
    public void updateText(String msgAccept) {
        this.textArea.setText(textArea.getText()+System.getProperty("line.separator")+msgAccept);
    }
}
