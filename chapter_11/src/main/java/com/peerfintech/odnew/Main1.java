package com.peerfintech.odnew;

import com.peerfintech.util.StringUtils;
import com.peerfintech.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/27
 * Time: 18:07
 * Description: 单核CPU任务调度
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("main1"));
        List<int[]> tasks = new ArrayList<>();
        List<int[]> completeTask = new ArrayList<>();
        while (in.hasNextLine()) {
            String inValue = in.nextLine();
            if (inValue.equals("")) {
                int cpuProcess = -1;
                int time = 1;
                while (true) {
                    // 判断是否有任务过来
                    for (int i = 0; i < tasks.size(); i++) {
                        if (tasks.get(i)[3] == time) {
                            tasks.get(i)[5] = 2;
                        }
                    }
                    if (cpuProcess != -1) {
                        tasks.get(cpuProcess)[4]--;
                        if (tasks.get(cpuProcess)[4] == 0) {
                            tasks.get(cpuProcess)[5] = 3;
                            tasks.get(cpuProcess)[6] = time;
                            completeTask.add(tasks.get(cpuProcess));
                        } else {
                            tasks.get(cpuProcess)[5] = 2;
                        }
                    }
                    // 从任务队列找到最早到达的优先级最高的任务
                    int max = Integer.MIN_VALUE;
                    int maxID  = -1;
                    for (int i = 0; i < tasks.size(); i++) {
                        if ( tasks.get(i)[5] == 2) {
                            if (tasks.get(i)[1] > max) {
                                max = tasks.get(i)[1];
                                maxID = i;
                            }
                        }
                    }
                    cpuProcess = maxID;
                    if (maxID == -1 && completeTask.size() == tasks.size()) {
                        break;
                    }
                    time++;
                }
                for (int i = 0; i < completeTask.size(); i++) {
                    System.out.println(completeTask.get(i)[0] + " " + completeTask.get(i)[6]);
                }
            } else {
                int[] temp = StringUtils.stringToArr(inValue, " ");
                int[] task = new int[temp.length + 3];
                for (int i = 0; i < temp.length; i++) {
                    task[i] = temp[i];
                }
                task[temp.length] = temp[2];
                task[temp.length + 1] = 0;
                tasks.add(task);
            }
        }
    }
}
