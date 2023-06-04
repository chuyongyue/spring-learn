package com.peerfintech;

import com.peerfintech.funcenhance.HuangShanScenicSpot;
import com.peerfintech.funcenhance.ScenicSpot;
import com.peerfintech.funcenhance.VisitEncoreable;
import com.peerfintech.xmlconfiguration.CompactDisc;
import com.peerfintech.xmlconfiguration.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/4 16:01
 **/
public class AspectApp {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(com.peerfintech.soundsystem.PlayerConfig.class);
//        CompactDisc dancePerformance = context.getBean(CompactDisc.class);
//        dancePerformance.playTrack(2);

//        SomeService target = new SomeService();

//        SomeService proxy = new CglibFactory().myCglibCreator();
//
//        String result = proxy.doFirst();
//        System.out.println(result);
//        proxy.doSecond();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "META-INF/spring/enhance.xml");
        ScenicSpot scenicSpot = context.getBean(ScenicSpot.class);
        scenicSpot.visit("zhangSan");
        VisitEncoreable va = (VisitEncoreable) scenicSpot;
        va.visitCount();
    }
}
