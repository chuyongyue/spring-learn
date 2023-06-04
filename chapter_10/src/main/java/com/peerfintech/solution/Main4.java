package com.peerfintech.solution;

import java.util.Scanner;

/**
 * 单词接龙的规则是:
 * 可用于接龙的单词,首字母必须要与前一个单词的尾字母相同；
 * 当存在多个首字母相同的单词时，取长度最长的单词；
 * 如果长度也相等，则取字典序最小的单词；
 * 已经参与接龙的单词不能重复使用；
 * 现给定一组全部由小写字母组成的单词数组，
 * 并指定其中一个单词为起始单词，进行单词接龙，
 * 请输出最长的单词串。
 * 单词串是单词拼接而成的，中间没有空格。
 * <p>
 * 单词个数 1 < N < 20
 * 单个单词的长度 1 ~ 30
 * <p>
 * 输入描述
 * 输入第一行为一个非负整数
 * 表示起始单词在数组中的索引k
 * 0 <= k < N
 * 输入的第二行为非负整数N
 * 接下来的N行分别表示单词数组中的单词
 * <p>
 * 输出描述
 * 输出一个字符串表示最终拼接的单词串
 * <p>
 * 示例一
 * 输入
 * 0
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * 输出
 * worddwordda
 * 示例一
 * 输入
 * 4
 * 6
 * word
 * dd
 * da
 * dc
 * dword
 * d
 * 输出
 * dwordda
 */
public class Main4 {
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int index = in.nextInt();
            int strNum = in.nextInt();
            in.nextLine();
            StrObj[] strObjs = new StrObj[strNum];
            for (int i = 0; i < strNum; i++) {
                StrObj obj = new StrObj();
                obj.value = in.nextLine();
                strObjs[i] = obj;
            }
            solution(strObjs, index);
        }
    }

    private static void solution(StrObj[] objs, int start) {
        sb.append(objs[start].value);
        objs[start].isUsed = true;
        int next = getNextWord(objs, start);
        if (next == -1) {
            System.out.println(sb.toString());
        } else {
            solution(objs, next);
        }
    }

    private static int getNextWord(StrObj[] objs, int current) {
        int res = -1;
        int curIndex = objs[current].value.length();
        for (int i = 0; i < objs.length; i++) {
            if (i != current && !objs[i].isUsed && objs[i].value.charAt(0) == objs[current].value.charAt(curIndex - 1)) {
                if (res == -1) {
                    res = i;
                } else {
                    if (objs[i].value.length() > objs[res].value.length()) {
                        res = i;
                    } else if (objs[i].value.length() == objs[res].value.length()) {
                        if (!compare(objs[i].value, objs[res].value)) {
                            res = i;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * @param val1
     * @param val2
     * @return val1 > val2 true
     */
    private static boolean compare(String val1, String val2) {
        int len = val1.length();
        boolean res = false;
        for (int i = 0; i < len; i++) {
            if (val1.charAt(i) > val2.charAt(i)) {
                res = true;
                break;
            } else if (val1.charAt(i) < val2.charAt(i)) {
                res = false;
                break;
            }
        }
        return res;
    }

    static class StrObj {
        boolean isUsed = false;
        String value;
    }
}
