package com.peerfintech.odnew;

import com.peerfintech.util.StringUtils;
import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/17
 * Time: 23:47
 * Description: 计算机网络信号
 */
public class Main3 {
    static int[][] arrs;
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("main3"));
        while (in.hasNextLine()) {
            int m = in.nextInt();
            int n = in.nextInt();
            arrs = new int[m][n];
            in.nextLine();
            for (int i = 0; i < m; i++) {
                arrs[i] = StringUtils.stringToArr(in.nextLine(), " ");
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arrs[i][j] > 0) {
                        x = i;
                        y = j;
                    }
                }
            }
            int i = in.nextInt();
            int j = in.nextInt();
            in.nextLine();
        }
    }

    private static void solution(int x, int y, int i, int j) {
        int m = x;
        int n = y;

    }
}
