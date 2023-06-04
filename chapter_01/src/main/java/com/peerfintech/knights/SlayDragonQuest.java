package com.peerfintech.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }

    public void init() {
        System.out.println("Person init-method");
    }

    public void destroy() {
        System.out.println("Person destroy-method");
    }


}
