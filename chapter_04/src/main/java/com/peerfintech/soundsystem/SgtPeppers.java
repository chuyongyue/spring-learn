package com.peerfintech.soundsystem;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 15:32
 **/
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public void playTrack(int trackNumber) {
        System.out.println("Playing " + trackNumber);
    }
}
