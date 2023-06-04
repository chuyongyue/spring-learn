package com.peerfintech.xmlconfiguration;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 16:05
 **/
public class AroundAudience {
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("xml around Silencing cell phones");
            System.out.println("XMl around Taking seats");
            jp.proceed();
            System.out.println("xml around CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("xml around Demanding a refund");
        }
    }
}
