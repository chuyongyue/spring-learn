package com.peerfintech.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


/**
 * @Description
 * @Author cy
 * @Date 2022/7/21 14:18
 **/

@Aspect
public class Audience {

    // 切点表达式
    @Pointcut("execution(** com.peerfintech.concert.Performance.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void taskSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    // 通知方法会在目标方法抛出异常后调用
    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
//
//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint jp) {
//        try {
//            System.out.println("Silencing cell phones");
//            System.out.println("Taking seats");
//            jp.proceed();
//            System.out.println("CLAP CLAP CLAP!!!");
//        } catch (Throwable e) {
//            System.out.println("Demanding a refund");
//        }
//    }
}
