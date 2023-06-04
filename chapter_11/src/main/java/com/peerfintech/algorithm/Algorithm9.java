package com.peerfintech.algorithm;

import com.peerfintech.util.UseCaseUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/23
 * Time: 23:19
 * Description:
 */
public class Algorithm9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("algo9"));
        while (in.hasNextLine()) {
            int curNum = in.nextInt();
            in.nextLine();
            int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            handle(arr, curNum);
        }
    }

    public static void handle(int[] arr, int curNum) {
        int left = 0;
        int right = 0;
        int len = 0;
        int maxLen = 0;
        int mid = arr.length / 2;
        Map<Integer, List<int[]>> map = new TreeMap<>();
        while (right < arr.length) {
            if (arr[right] != curNum) {
                if (len != 0) {
                    int[] indexes = new int[2];
                    indexes[0] = left;
                    indexes[1] = right;
                    List<int[]> resList = map.get(len);
                    if (resList == null) {
                        resList = new ArrayList<>();
                    }
                    resList.add(indexes);
                    map.put(len, resList);
                }
                maxLen = Math.max(maxLen, len);
                left = right;
                len = 0;
            } else {
                len++;
            }
            right++;
        }

        if (len != 0) {
            List<int[]> resList = map.get(len);
            if (resList == null) {
                resList = new ArrayList<>();
            }
            int[] indexes = new int[2];
            indexes[0] = left;
            indexes[1] = right;
            resList.add(indexes);
            map.put(len, resList);
            maxLen = Math.max(maxLen, len);
        }

        List<int[]> list = map.get(maxLen);
        int ans = Integer.MAX_VALUE;
        int toMid = Math.abs(mid - ans);
        for (int i = 0; i < list.size(); i++) {
            int[] inx = list.get(i);
            if (arr[inx[0]] == 0) {
                if (maxLen + 1 + otherSideLen(map,1, inx[0]) <= 5) {
                    int tempTomid = Math.abs(mid - inx[0]);
                    if (tempTomid < toMid) {
                        toMid = tempTomid;
                        ans = inx[0];
                    } else if (tempTomid == toMid) {
                        if (inx[0] < ans) {
                            ans = inx[0];
                        }
                    }
                }
            }

            if (inx[1] < arr.length && arr[inx[1]] == 0) {
                if (maxLen + 1 + otherSideLen(map,0, inx[1]) <= 5) {
                    int tempTomid = Math.abs(mid - inx[1]);
                    if (tempTomid < toMid) {
                        toMid = tempTomid;
                        ans = inx[1];
                    } else if (tempTomid == toMid) {
                        if (inx[1] < ans) {
                            ans = inx[1];
                        }
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static int otherSideLen(Map<Integer, List<int[]>> map, int local, int val) {
        Set<Integer> keySet = map.keySet();
        int res = 0;
        for (Integer key: keySet) {
            List<int[]> list = map.get(key);
            boolean isget = false;
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                if (ints[local] ==  val) {
                    isget = true;
                    break;
                }
            }
            if (isget) {
                res = key;
                break;
            }
        }
        return res;
    }

    private static void print(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
