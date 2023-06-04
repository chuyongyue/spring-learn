package com.peerfintech.schedule;

import java.util.Date;
import java.util.TimerTask;

public class DoSomethingTimerTask extends TimerTask {
    private String taskName;
    public DoSomethingTimerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(new Date() + ": 任务 " + taskName + " 被执行");
    }
}
