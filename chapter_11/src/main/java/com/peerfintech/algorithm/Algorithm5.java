package com.peerfintech.algorithm;

import com.peerfintech.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/21
 * Time: 20:57
 * Description: 和位s的连续正整数
 */
public class Algorithm5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("algorithm5"));
        while (in.hasNextLine()) {
            Algorithm5 algorithm5 = new Algorithm5();
            List<List<Integer>> listList = algorithm5.solution(in.nextInt());
            System.out.println(listList.toString());
        }
    }
    public List<List<Integer>> solution(int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(target <= 1) {
            return list;
        }
        int temp = 0;
        int end = 1;
        int start = 1;
        while (end < target / 2 + 2) {
            while (temp < target) {
                temp = temp + end;
                end++;
            }

            while (temp > target) {
                temp = temp - start;
                start++;
            }

            if (temp == target) {
                List<Integer> integerList = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    integerList.add(i);
                }
                temp = temp - start;
                start++;
                list.add(integerList);
            }
        }
        return list;
    }
}
