package com.peerfintech.odthree;

import com.peerfintech.util.UseCaseUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/3
 * Time: 20:25
 * Description: 士兵过河 贪心做法
 */
public class ThreeMain3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odthree3"));
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int limit = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            // 最少成功过河的人数
            int min = 0;
            // 最多成功过河的人数
            int max = n;
            while (min <= max) {
                // mid中间过河的人数
                int mid = (min + max) / 2;
                // 计算mid个人过河所需的最短时间need
                int need = getMinCrossRiverTime(mid, nums);
                if (need > limit) {

                } else if (need < limit) {

                } else {
                    //
                }
            }
        }
    }

    // 计算将n个人运到河对岸所需要花费的最少时间
    public static int getMinCrossRiverTime(int n, int[] t) {
        int cost = 0;
        while (n > 0) {
            if (n == 1) {
                cost += t[0];
                break;
            } else if (n == 2) {
                cost += t[1];
                break;
            } else if (n == 3) {
                cost += t[0] + t[1] + t[2];
                break;
            } else {
                cost += Math.min(t[n-1] + t[0] + t[0] + t[n-2], t[0] + t[1] + t[n-1] + t[1]);
                n = n - 2;
            }
        }
        return cost;
    }
}
