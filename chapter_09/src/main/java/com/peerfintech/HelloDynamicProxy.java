package com.peerfintech;

import java.lang.reflect.InvocationHandler;

/**
 * @Description jvm动态生成字节码，加载后创建新的代理对象
 * @Author cy
 * @Date 2022/8/4 15:18
 **/
public class HelloDynamicProxy implements Hello {
    InvocationHandler handler;

    public HelloDynamicProxy(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void morning(String name) {
        try {
            handler.invoke(this, Hello.class.getMethod("morning", String.class), new Object[] {name});
        } catch (Throwable noSuchMethodException) {
            System.out.println(noSuchMethodException.getMessage());
        }
    }
}
