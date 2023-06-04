package com.peerfintech.concert;

/**
 * @Description 使用cglib实现代理
 * @Author cy
 * @Date 2023/1/5 13:31
 **/
public class SomeService {
    public String doFirst() {
        System.out.println("执行doFirst()方法");
        return "abcde";
    }

    public void doSecond() {
        System.out.println("doSecond()方法");
    }

}
