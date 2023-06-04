package com.peerfintech.odfour;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/10
 * Time: 23:15
 * Description: 最差产品奖
 */
public class FourMain3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 从当前产品开始前M个产品中最差的产品
      while (in.hasNext()) {
          int len = Integer.parseInt(in.nextLine());
          String str = in.nextLine();
          String[] strArr = str.split(",");
          for (int i = 0; i < strArr.length - len + 1; i++) {
              int min = Integer.MAX_VALUE;
              if (i != 0) {
                  System.out.print(",");
              }
              for (int innner = 0; innner < len; innner++) {
                  int cur = Integer.parseInt(strArr[i + innner]);
                  if (cur < min) {
                      min = cur;
                  }
              }
              System.out.print(min);
          }
      }

    }
}
