package com.peerfintech.xmlconfiguration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 16:42
 **/
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<>();

    public void trackPlayed(int trackNumber) { }

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        System.out.println("blank disc number " + currentCount);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}