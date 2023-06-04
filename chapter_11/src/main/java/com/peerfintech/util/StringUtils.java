package com.peerfintech.util;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/17
 * Time: 20:27
 * Description:
 */
public class StringUtils {
    public static int[] stringToArr(String str, String regex) {
        String[] strings = str.split(regex);
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums;
    }
}
