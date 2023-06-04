package com.peerfintech.myaspectj;

public aspect LogAspect {
    // 定义一个 PointCut
    // 该PointCut 对应于指定HelloWorld对象的sayHello方法 sayHello是连接点，pointCut(切点)匹配多个连接点
    pointcut logPointcut():execution(void HelloWorld.sayHello());

    // 在 logPointcut 之后执行下面代码块
    after():logPointcut() {
        System.out.println("log recording...");
    }
}
