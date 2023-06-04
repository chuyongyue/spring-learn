package com.peerfintech.algorithm;

import com.peerfintech.util.StringUtils;
import com.peerfintech.util.UseCaseUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/21
 * Time: 22:00
 * Description: 和为s的两个数字
 */
public class Algorithm6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("algorithm6"));
        while (in.hasNextLine()) {
            Algorithm6 algorithm6 = new Algorithm6();
            int[] array = StringUtils.stringToArr(in.nextLine(), ",");
            int sum = in.nextInt();
            in.nextLine();
            algorithm6.FindNumbersWithSum(array, sum);
        }
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length <= 1) {
            return list;
        }
        int first = 0;
        int second = 1;
        int temp = array[first] + array[second];
        while (second < array.length) {
            while (temp < sum) {
                temp = temp  - array[second];
                second = second + 1;
                temp = temp + array[second];
            }

            if (temp == sum) {
                list.add(first);
                list.add(second);
                break;
            }
        }
        return list;
    }
}
