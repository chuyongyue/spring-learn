package com.peerfintech;

import com.peerfintech.myaspectj.Performance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/6 17:50
 **/
public class AspectApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "META-INFO/spring/context.xml");
        Performance scenicSpot = context.getBean(Performance.class);
        scenicSpot.perform("zhangsan");
    }
}
