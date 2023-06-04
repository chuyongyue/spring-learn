package com.peerfintech.algorithm;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/25
 * Time: 21:33
 * Description: leetcode 面试题16.18.模式匹配 动态规划 + 滑动窗口
 */
public class Algorithm8 {
    public static void main(String[] args) {

    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
    }
    public int help(int[] nums, int firstLen, int secondLen) {
        int suml = 0;
        for (int i = 0; i < firstLen; i++) {
            suml = suml + nums[i];
        }
        int maxSumL = suml;
        int sumr = 0;
        for (int i = firstLen; i < firstLen + secondLen; i++) {
            sumr = sumr + nums[i];
        }
        int res = maxSumL + sumr;
        for (int i = firstLen + secondLen, j = firstLen; i < nums.length; i++,j++) {
            suml = suml + nums[j] - nums[j - firstLen];
            sumr = sumr + nums[i] - nums[i-secondLen];
            maxSumL = Math.max(maxSumL, suml);
            res = Math.max(res, maxSumL + sumr);
        }
        return res;
    }
}
