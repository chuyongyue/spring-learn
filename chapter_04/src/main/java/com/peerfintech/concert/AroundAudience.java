package com.peerfintech.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description 创建环绕通知
 * @Author cy
 * @Date 2023/1/5 15:12
 **/
@Aspect
public class AroundAudience {
    @Pointcut("execution(** com.peerfintech.concert.Performance.perform(..))")
    public void performce() { }

    @Around("performce()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones around");
            System.out.println("Taking seats around");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund around");
        }
    }
}
