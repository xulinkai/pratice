package com.xulk.designPattern.mashibing.state;

/**
 * @description:
 * @author:
 * @create: 2019-09-08 04:11
 **/
public class MM {

    public MMState mmState;

    public MM(MMState mmState) {
        this.mmState = mmState;
    }

    public void smile(){
        mmState.happyState();
    }

    public void sad(){
        mmState.sadState();
    }

    public void hungry(){
        mmState.hungryState();
    }
}
