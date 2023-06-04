package com.peerfintech.myaspectj;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/6 17:33
 **/
public class CriticiamEngineImpl implements CriticismEngine {
    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    // injected
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
