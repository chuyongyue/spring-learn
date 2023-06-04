package com.peerfintech.myaspectj;

/**
 * 实现表演的评论员
 */
public aspect CriticAspect {

    pointcut performance(): execution(* com.peerfintech.myaspectj.Performance.perform(..));

    after():performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
