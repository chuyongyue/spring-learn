package com.peerfintech.odtwo;

import com.peerfintech.util.StringUtils;
import com.peerfintech.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/27
 * Time: 21:53
 * Description: 服务中心的最佳距离 二分法
 */
public class OdTwo1 {
    public static List<int[]> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odtwo1"));
        while (in.hasNextLine()) {
            list = new ArrayList<>();
            // 对位置进行排序
            // 左边界小的在前，如果左边界相等，右边界小的在前
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int[] ints = new int[2];
                ints[0] = in.nextInt();
                ints[1] = in.nextInt();
                list.add(ints);
            }
            list.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            int left = list.get(0)[0];
            int right = list.get(n-1)[1];
            // 最左侧到各街道的距离和
            int leftDance = handle(left);
            // 最右侧到各街道的距离和
            int rightDance = handle(right);
            while (right - left > 1) {
                // 中心位置
                int mid = (right + left) / 2;
                // 中心位置到各街道的距离和
                int midDance = handle(mid);
                if (leftDance < rightDance) {
                    right = mid;
                    rightDance = midDance;
                } else {
                    left = mid;
                    leftDance = midDance;
                }
            }
            System.out.println(Math.min(leftDance, rightDance));
        }
    }

    public static int handle(int localtion) {
        int res = 0;
        for (int[] ints:list) {
            int left = ints[0];
            int right = ints[1];
            if (localtion < left) {
                res = res + left - localtion;
            } else if (localtion > right) {
                res = res + localtion - right;
            }
        }
        return res;
    }
}
