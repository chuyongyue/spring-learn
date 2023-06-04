package com.peerfintech.bean.soundsystem;
import org.springframework.stereotype.Component;
// 给这个bean指定一个ID
@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";
  
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }
  
}
