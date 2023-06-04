package com.peerfintech.odfour;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/10
 * Time: 20:32
 * Description: 组装新的数组
 */
public class FourMain2 {
    public static int max;
    public static int min;
    public static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odfour2"));
        String[] strings = in.nextLine().split(" ");
        max = Integer.parseInt(strings[strings.length - 1]);
        min = Integer.parseInt(strings[0]);
        int M = in.nextInt();
        handle(min, M);
        System.out.println(res);
    }

    public static void handle(int n, int sum) {
        if (sum < min) {
            res++;
            return;
        }
        if (n > sum) {
            return;
        }
        int i = 0;
        while (true) {
            handle(n+1, sum - i*n);
            i++;
            if (sum - i*n <= 0) {
               if (sum - i * n == 0) {
                   res++;
               }
                break;
            }
        }
    }
}
