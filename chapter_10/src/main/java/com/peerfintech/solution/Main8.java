package com.peerfintech.solution;

import java.util.Scanner;

/**
 * @Description 给定一个二维的0-1矩阵,求全由1构成的最大正方形面积.
 *
 * Input:[['1','0','1','0','0'],
 *        ['1','0','1','1','1'],
 *        ['1','1','1','1','1'],
 *        ['1','0','0','1','0']]
 *
 * Output:4
 * @Author cy
 * @Date 2023/4/7 16:03
 **/
public class Main8 {
    static int maxArea = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // 行
            int row = in.nextInt();
            // 列
            int col = in.nextInt();
            in.nextLine();
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = in.nextInt();
                    if (matrix[i][j] == 1) {
                        maxArea = 1;
                    }
                }
                in.nextLine();
            }
            System.out.println(solution(matrix, row, col));
        }
    }
    private static int solution(int[][] matrix, int row, int col) {
        // 从边长为2的边开始遍历.正方形在数组上面移动
        for (int i = 2; i <= Math.min(row, col); i++) {
            int get = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (j + i - 1 < row && k + i - 1 < col) {
                        get = 1;
                        for (int l = j; l <= j + i - 1; l++) {
                            for (int m = k; m <= k + i - 1; m++) {
                                if (matrix[l][m] == 0) {
                                    get = 2;
                                }
                            }
                        }
                        if (get == 1) {
                           maxArea = i * i;
                           break;
                        }
                    }
                }
                if (get == 1) {
                    break;
                }
            }
        }
        return maxArea;
    }
}