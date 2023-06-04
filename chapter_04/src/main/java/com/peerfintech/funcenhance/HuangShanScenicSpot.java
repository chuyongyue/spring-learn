package com.peerfintech.funcenhance;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 17:27
 **/
public class HuangShanScenicSpot implements ScenicSpot {
    @Override
    public void visit(String person) {
        System.out.println(person + " come here for a visit");
    }
}
