package com.peerfintech.algorithm;

import com.peerfintech.util.UseCaseUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/24
 * Time: 23:42
 * Description:
 */
public class Algorithm10 {
    public static int waitLen; // 等待队列长度
    public static int execLen; // 执行者数量

    public static int res2 = 0; // 丢弃数量
    public static void main(String[] args) {
        Scanner input = new Scanner(UseCaseUtil.getInput("algo10"));
        while (input.hasNextLine()) {
            int[] arr = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            waitLen = input.nextInt();
            execLen = input.nextInt();
            res2 = 0;
            Deque<Task> taskDeque = new ArrayDeque<>();
            for (int i = 0; i < arr.length - 1; i+=2) {
                Task task = new Task(arr[i], arr[i+1]);
                taskDeque.addLast(task);
            }
            Deque<Task> waitDeque = new ArrayDeque<>();
            List<Task> execList = new ArrayList<>();
            handle(taskDeque, waitDeque, execList);
        }
    }

    public static void handle(Deque<Task> taskDeque, Deque<Task> waitDeque, List<Task> execList) {
        // 计时器
        int curTime = 1;
        while (true) {
            // 首先处理处理执行队列，是否有任务执行完
            for (int i = 0; i < execList.size(); i++) {
                Task task = execList.get(i);
                if (task.startTime + task.runningTime <= curTime) {
                    execList.remove(task);
                    i--;
                }
            }

            if (!taskDeque.isEmpty()) {
                // 任务队列不为空，队头元素
                Task task = taskDeque.peek();
                if (task.startTime == curTime) {
                    // 有任务到来
                    Task getTask = taskDeque.removeFirst();
                    // 有空闲者
                    if (execList.size() < execLen) {
                        // 判断等待队列中是否任务
                        if (waitDeque.size() > 0) {
                            // 有,取最老的任务
                            Task task1 = waitDeque.removeFirst();
                            task1.startTime = curTime;
                            execList.add(task1);
                            waitDeque.addLast(getTask);
                        } else {
                            // 没有等待的，直接执行
                            execList.add(getTask);
                        }
                    }else {
                        // 没有空闲者
                        if (waitDeque.size() >= waitLen) {
                            //队列已满
                            waitDeque.removeFirst();
                            res2++;
                        }
                        waitDeque.addLast(task);
                    }
                }
            }

            while (execList.size() < execLen) {
                if (waitDeque.isEmpty()) {
                    break;
                }
                Task curTask = waitDeque.removeFirst();
                curTask.startTime = curTime;
                execList.add(curTask);
            }
            if (execList.size() == 0 && taskDeque.isEmpty()) {
                break;
            }
            curTime++;
        }
        System.out.println(curTime + " " + res2);
    }
}

class Task {
    public int startTime;
    public int runningTime;

    public Task(int startTime, int runningTime) {
        this.startTime = startTime;
        this.runningTime = runningTime;
    }
}
