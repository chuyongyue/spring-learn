package com.peerfintech.algorithm;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/19
 * Time: 21:44
 * Description: 无重复字符的最长子串
 */
public class Algorithm1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("algorithm1"));
        while (in.hasNextLine()) {
            String str = in.nextLine();
            System.out.println(str);
        }
    }
}
