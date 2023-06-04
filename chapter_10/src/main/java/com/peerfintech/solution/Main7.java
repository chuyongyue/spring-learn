package com.peerfintech.solution;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/6
 * Time: 20:43
 * Description: 新员工安排座位友好度
 * 工位由序列F1,F2…Fn组成，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。
 *
 * 1、某一空位的友好度为左右连续老员工数之和，
 * 2、为方便新员工学习求助，优先安排友好度高的空位，
 *
 * 给出工位序列，求所有空位中友好度的最大值。
 *
 * 输入描述：
 *
 * 第一行为工位序列：F1，F2…Fn组成，
 * 1<=n<=10000，Fi值为0、1或2。其中0代表空置，1代表有人，2代表障碍物。
 *
 * 输出描述：
 *
 * 所有空位中友好度的最大值。如果没有空位，返回0。
 *
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 0 1 0
 *
 * 输出
 *
 * 1
 *
 * 说明
 *
 * 第1个位置和第3个位置，友好度均为1。
 *
 * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * 1 1 0 1 2 1 0
 *
 * 输出
 *
 * 3
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String val = in.nextLine();
            String[] vals = val.split(" ");
            int[] num = new int[vals.length];
            for (int i = 0; i < vals.length; i++) {
                num[i] = Integer.parseInt(vals[i]);
            }
            solution(num);
        }
    }

    private static void solution(int[] nums) {
        // 首先遍历数组找到0
        // 找到0之后向两边遍历
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, bothwayTraversal(nums, i));
            }
        }
        System.out.println(max);
    }

    // 从给定位置向左右遍历，直到数组的头，尾，或者0，障碍物的位置。统计连续1的位置
    private static int bothwayTraversal(int[] nums, int location) {
        int res = 0;
        // 向右遍历
        for (int i = location + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                res++;
            } else {
                break;
            }
        }

        // 向左遍历
        for (int i = location - 1; i >= 0 ; i --) {
            if (nums[i] == 1) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
