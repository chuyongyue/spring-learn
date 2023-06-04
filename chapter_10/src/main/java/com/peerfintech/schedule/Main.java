package com.peerfintech.schedule;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Timer timer  = new Timer();
        timer.schedule(new DoSomethingTimerTask("periodDemo"), 1000L);
    }
}
