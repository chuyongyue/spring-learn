package com.peerfintech.funcenhance;

/**
 * @Description 功能增强
 * @Author cy
 * @Date 2023/1/5 17:33
 **/
public class DefaultEnhance implements VisitEncoreable {
    private int visitCount;
    @Override
    public void visitCount() {
        visitCount++;
        System.out.println("bean current count is " + visitCount);
    }
}
