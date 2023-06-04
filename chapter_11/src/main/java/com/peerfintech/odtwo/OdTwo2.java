package com.peerfintech.odtwo;

import com.peerfintech.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/28
 * Time: 23:05
 * Description: 服务中心选址 暴力解法
 */
public class OdTwo2 {
    public static List<int[]> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odtwo1"));
        while (in.hasNextLine()) {
            list = new ArrayList<>();
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
            // 最左边的坐标
            int min = list.get(0)[0];
            // 最右边的坐标
            int max = list.get(n-1)[1];

            int ans = Integer.MAX_VALUE;
            for (int i = min; i <= max; i++) {
                ans = Math.min(ans, handle(i));
            }
            System.out.println(ans);
        }
    }

    public static int handle(int loaction) {
        int res = 0;
        for (int[] ints: list) {
            int left = ints[0];
            int right = ints[1];
            if (loaction < left) {
                res = res + left - loaction;
            } else if (loaction > right) {
                res = res + loaction - right;
            }
        }
        return res;
    }
}
