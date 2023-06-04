package com.peerfintech.soundsystem;

import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description 使用参数化的通知来记录磁道播放的次数
 * @Author cy
 * @Date 2023/1/5 15:21
 **/

@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    // args(trackNumber)限定符，表明传递给playTrack()方法的int类型参数也会传递到通知中去，参数的名称 trackNumber 也与切点方法签名中的参数相匹配
    @Pointcut("execution(* com.peerfintech.soundsystem.CompactDisc.playTrack(int) )" +
            "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) { }

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        System.out.println("current count " + currentCount);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}