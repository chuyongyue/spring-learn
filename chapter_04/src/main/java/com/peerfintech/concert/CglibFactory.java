package com.peerfintech.concert;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 13:55
 **/
public class CglibFactory implements MethodInterceptor {

    public SomeService myCglibCreator() {
        Enhancer enhancer = new Enhancer();
        //将目标类设置为父类，cglib动态代理增强的原理就是子类增强父类,cglib不能增强目标类为final的类
        //因为final类不能有子类
        enhancer.setSuperclass(SomeService.class);
        //设置回调接口,这里的MethodInterceptor实现类回调接口，而我们又实现了MethodInterceptor,其实
        //这里的回调接口就是本类对象,调用的方法其实就是intercept()方法
        enhancer.setCallback(this);
        //create()方法用于创建cglib动态代理对象
        return (SomeService) enhancer.create();
    }

    //回调接口的方法
    //回调接口的方法执行的条件是：代理对象执行目标方法时会调用回调接口的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = methodProxy.invokeSuper(o, objects);

        //这里实现将返回值字符串变为大写的逻辑
        if(result != null) {
            result = ((String) result).toUpperCase();
        }
        return result;
    }

}