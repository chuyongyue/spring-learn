package com.peerfintech;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author cy
 * @Date 2022/8/4 14:58
 **/
public class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 打印方法名称和参数

        // 调用真实的方法
        return method.invoke(target, args);
    }
}
