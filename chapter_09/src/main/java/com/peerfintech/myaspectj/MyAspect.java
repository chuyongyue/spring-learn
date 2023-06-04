package com.peerfintech.myaspectj;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/6 11:02
 **/
public class MyAspect {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        HelloAspectJ hello = new HelloAspectJ();
        System.out.println("hello：" + hello.closed);
    }
}
