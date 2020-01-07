package com.xulk.mashibing.netty.netty.tank.v03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @description:
 * @author:
 * @create: 2020-01-05 00:06
 **/
public class ServerFrame extends Frame {

    public static final ServerFrame INSTANCE = new ServerFrame();


    Button btnStart = new Button("start");
    TextArea taLeft = new TextArea();
    TextArea taRight = new TextArea();
    Server server = new Server();

    public ServerFrame(){
        this.setSize(1600, 600);
        this.setLocation(300, 30);
        this.add(btnStart, BorderLayout.NORTH);
        //1行 2列
        Panel p = new Panel(new GridLayout(1,2));
        p.add(taLeft);
        p.add(taRight);
        this.add(p);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        /*//button的点击事件
        this.btnStart.addActionListener((e)->{
            server.serverStart();
        });*/
    }

    public static void main(String[] args) {
        ServerFrame.INSTANCE.setVisible(true);
        ServerFrame.INSTANCE.server.serverStart();
    }

    /**
    * @Description: 更新服务端的信息展示  左边
    * @Date: 2020/1/5  15:45
    */
    public void updateServerMsg(String msg) {
        this.taLeft.setText(taLeft.getText()+System.getProperty("line.separator")+msg);
    }

    /**
    * @Description: 更新客户端的信息展示  右边
    * @Date: 2020/1/5  15:56
    */
    public void updateClientMsg(String msg){
        this.taRight.setText(taRight.getText()+System.getProperty("line.separator")+msg);
    }

}
