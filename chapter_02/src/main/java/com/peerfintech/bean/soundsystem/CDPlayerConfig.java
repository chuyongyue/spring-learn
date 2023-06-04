package com.peerfintech.bean.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.peerfintech.bean")
//@ComponentScan(basePackages = ("", ""))
public class CDPlayerConfig {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                dp[i] = 0;
            }

            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            System.out.println(dp[n]);
        }
    }
}
