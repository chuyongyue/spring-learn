package com.peerfintech.class03;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/22
 * Time: 8:14
 * Description: 二分查找, arr 有序
 */
public class BExist {
    public boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = (L+R) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }
}
