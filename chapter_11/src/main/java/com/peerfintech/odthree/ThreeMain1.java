package com.peerfintech.odthree;

import com.peerfintech.util.UseCaseUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/5/3
 * Time: 9:45
 * Description: 快递投放问题
 */
public class ThreeMain1 {
    public static int[][] loads;
    public static boolean[][] isVisted;
    public static List<Package> packageList;

    public static Map<String, String[]> loadInfo;

    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("odthree1"));
        while (in.hasNextLine()) {
            loads = new int[26][26];
            int m = in.nextInt();
            int n = in.nextInt();
            in.nextLine();
            packageList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                Package pk = new Package();
                String[] inVal = in.nextLine().split(" ");
                pk.packageName = inVal[0];
                pk.startPoint = inVal[1].charAt(0);
                pk.endPoint = inVal[2].charAt(0);
                packageList.add(pk);
            }
            loadInfo = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] strings = in.nextLine().split(" ");
                String loadKey = strings[0] + strings[1];
                loads[strings[0].charAt(0) - 'A'][strings[1].charAt(0) - 'A'] = 1;
                loads[strings[1].charAt(0) - 'A'][strings[0].charAt(0) - 'A'] = 1;
                loadInfo.put(loadKey, Arrays.copyOfRange(strings, 2, strings.length));
            }
            handle();
        }
    }

    public static void handle() {
        List<String> list = new ArrayList<>();
        for (Package pk: packageList) {
            isVisted = new boolean[26][26];
            if (!BFS(pk)) {
                list.add(pk.packageName);
            }
        }
        list.sort((a, b) -> {
            return a.charAt(a.length() - 1) - b.charAt(b.length() - 1);
        });
        if (list.size() == 0) {
            System.out.println("none");
        } else {
            for (String str: list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    // 送货
    public static boolean BFS(Package pk) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.addLast(pk.startPoint);
        boolean isReach = false;
        while (!deque.isEmpty()) {
            char start = deque.pollFirst();
            for (int i = 0; i < 26; i++) {
                if (loads[start - 'A'][i] == 1 && !isVisted[start -'A'][i]) {
                    isVisted[start - 'A'][i] = true;
                    isVisted[i][start - 'A'] = true;
                    // 判断该路径是否可以走的通
                    char point = (char) (i + 'A');
                    if (check(start, point, pk)) {
                        if (pk.endPoint == point) {
                            isReach =  true;
                            break;
                        } else {
                            deque.addLast(point);
                        }
                    }
                }
            }
            if (isReach) {
                break;
            }
        }
        return isReach;
    }

    public static boolean check(char start, char end, Package pk) {
        StringBuilder sb = new StringBuilder();
        if (start > end) {
            sb.append(end);
            sb.append(start);
        } else {
            sb.append(start);
            sb.append(end);
        }
        String[] strings = loadInfo.get(sb.toString());
        for (int i = 0; i < strings.length; i++) {
            if (pk.packageName.equals(strings[i])) {
                return false;
            }
        }
        return true;
    }
}

class Package {
    public String packageName;
    public char startPoint;
    public char endPoint;
}
