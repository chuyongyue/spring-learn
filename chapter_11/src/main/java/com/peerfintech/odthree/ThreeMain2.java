package com.peerfintech.odthree;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/3
 * Time: 16:53
 * Description: 取出尽量少的球
 */
public class ThreeMain2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odthree2"));
        while (in.hasNextLine()) {
            int sum = in.nextInt();
            int n = in.nextInt();
            int[] bucketBallNums = new int[n];
            for (int i = 0; i < n; i++) {
                bucketBallNums[i] = in.nextInt();
            }

        }
    }

    public static int[] handle(int[] bucketBallNums, int sum) {
        int allSum = 0;
        for (int i = 0; i < bucketBallNums.length; i++) {
            allSum = allSum + bucketBallNums[i];
        }
        if (allSum < sum) {
            return null;
        } else {

        }
        return null;
    }
}
