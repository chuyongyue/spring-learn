package com.peerfintech.myaspectj;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/6 17:25
 **/
public class SingingPerformance implements Performance {
    @Override
    public void perform(String performer) {
        System.out.println("now let's welcome " + performer + " to the stage");
    }
}
