package com.peerfintech.myaspectj;

public aspect TxAspect {
    void around(): call(void HelloWorld.sayHello()) {
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                System.out.print(stackElements[i].getClassName()+"/t");
                System.out.print(stackElements[i].getFileName()+"/t");
                System.out.print(stackElements[i].getLineNumber()+"/t");
                System.out.println(stackElements[i].getMethodName());
                System.out.println("-----------------------------------");
            }
        }
        System.out.println("start a transaction...");
        proceed();
        System.out.println("end a transaction...");
    }
}