package com.peerfintech.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/5
 * Time: 8:32
 * Description: 第K长子串
 * 题目描述
 * 给定一个字符串
 * 只包含大写字母
 * 求在包含同一字母的子串中
 * 长度第K长的子串
 * 相同字母只取最长的子串
 *
 * 输入描述
 * 第一行 一个子串 1 < len <= 100
 * 只包含大写字母
 * 第二行为k的值
 *
 * 输出描述
 * 输出连续出现次数第k多的字母的次数
 * 如果子串中只包含同一字母的子串数小于k
 * 则输出-1
 *
 * 示例一
 * 输入
 * AABAAA
 * 2
 * 输出
 * 1
 * 说明
 * 同一字母连续出现最多的A，3次
 * 第二多2次，但A出现连续3次
 *
 * ¶示例二
 * 输入
 * AAAAHHHBBCDHHHH
 * 3
 * 输出
 * 2
 */
public class Main5 {

    static Map<Character, Integer> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            map = new HashMap<>();
            String strIn = in.nextLine();
            int k =  in.nextInt();
            System.out.println(solution(strIn, k));
            in.nextLine();
        }
    }
    private static int solution(String val, int k) {
        char preChar = val.charAt(0);
        int prelens = 1;
        for (int i = 1; i < val.length(); i++) {
            if (preChar == val.charAt(i)) {
                prelens++;
            } else {
                if (map.get(preChar) == null || map.get(preChar) < prelens) {
                    map.put(preChar, prelens);
                }
                preChar = val.charAt(i);
                prelens = 1;
            }
        }
        if (map.get(preChar) == null || map.get(preChar) < prelens) {
            map.put(preChar, prelens);
        }
        if (map.size() < k) {
            return -1;
        }
        int[] nums = new int[map.size()];
        // 对map中的值排序
        int i = 0;
        for (Character ch : map.keySet()) {
            InsertSort(nums, map.get(ch), i);
            i++;
        }
        // 在输出第k大的数
        return nums[k-1];
    }

    private static void InsertSort(int[] nums, int val, int len) {
        if (len == 0) {
            nums[0] = val;
        } else {
            for (int i = 0; i <= len; i++) {
                if (i == len) {
                    nums[i] = val;
                } else {
                    if (val > nums[i]) {
                        // 插入
                        moveBack(nums, i, len);
                        nums[i] = val;
                        break;
                    }
                }
            }
        }
    }

    // 向后一定
    private static void moveBack(int[] nums, int start, int len) {
        for (int i = len-1; i >= start ; i--) {
            nums[i+1] = nums[i];
        }
    }
}
