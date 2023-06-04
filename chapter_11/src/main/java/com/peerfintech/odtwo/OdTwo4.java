package com.peerfintech.odtwo;

import com.peerfintech.util.UseCaseUtil;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/29
 * Time: 16:51
 * Description: 几何平均值最大子数组
 */
public class OdTwo4 {
    public static double max; // 最大几何平均值
    public static int ansIndex; // 当前正在处理数据的索引
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odtwo3"));
        while (in.hasNextLine()) {
            int N = in.nextInt();
            int L = in.nextInt();
            double[] doubles = new double[N];
            for (int i = 0; i < N; i++) {
                doubles[i] = in.nextDouble();
            }
            int resIndex = 0;
            int resLen = 0;
            for (int i = L; i <= N; i++) {
                if (handle(i, doubles)) {
                    resIndex = ansIndex;
                    resLen = i;
                }
            }
            System.out.println(resIndex + " " + resLen);
        }
    }

    // 返回当前长度子串是否满足
    public static boolean handle(int len, double[] doubles) {
        double maxInLen = 1;
        for (int i = 0; i < len; i++) {
            BigDecimal num1 = new BigDecimal(String.valueOf(maxInLen));
            BigDecimal num2 = new BigDecimal(String.valueOf(doubles[i]));
            maxInLen = num1.multiply(num2).doubleValue();
        }

        ansIndex = 0; // 初始化索引位置
        double count = maxInLen;
        for (int i = len; i < doubles.length; i++) {
            // 滑动数组
            count = count * doubles[i] / doubles[i-len];
            if (count > maxInLen) {
                ansIndex = i - len + 1;
                maxInLen = count;
            }
        }

        double CFG = Math.pow(maxInLen, (double) 1/len);
        if (CFG > max) {
            max = CFG;
            return true;
        }
        return false;
    }
}
