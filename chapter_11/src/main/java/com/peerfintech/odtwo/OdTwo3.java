package com.peerfintech.odtwo;

import com.peerfintech.util.UseCaseUtil;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/29
 * Time: 15:33
 * Description: 几何平均值最大子数组
 */
public class OdTwo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odtwo3"));
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int minLen = in.nextInt();
            double[] nums = new double[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextDouble();
            }
            handle(nums, minLen);
        }
    }
    public static void handle(double[] nums, int minLen) {
        double val = Double.MIN_VALUE;
        int ansIndex = 0;
        int ansLen = 0;
        for (int i = minLen; i <= nums.length; i++) {
            double maxInLen = 1;
            for (int j = 0; j < i; j++) {
                BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
                BigDecimal num2 = new BigDecimal(String.valueOf(nums[j]));
                maxInLen = num1.multiply(num2).doubleValue();
            }
            int startIndex = 0;
            double count = maxInLen;
            for (int j = i; j < nums.length; j++) {
                count = count * nums[j] / nums[j-i];
                if (count > maxInLen) {
                    startIndex = j - i + 1;
                    maxInLen = count;
                }
            }
            double CFG = Math.pow(maxInLen, (double) 1 / i);
            if (CFG > val) {
                ansIndex = startIndex;
                ansLen = i;
                val = CFG;
            }
        }

        System.out.println(ansIndex + " " + ansLen);
    }

}
