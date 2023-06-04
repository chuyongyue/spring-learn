package com.peerfintech.odnew;

import com.peerfintech.util.StringUtils;
import com.peerfintech.util.UseCaseUtil;

import java.util.*;

/**
 * @Description AI处理器组合
 * @Author cy
 * @Date 2023/4/17 15:56
 **/
public class Main2 {
    static Map<Integer, List<Integer>> map;
    static List<List<Integer>> listList;
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("main2"));
        while (in.hasNextLine()) {
            map = new HashMap<>();
            listList = new ArrayList<>();
            String strVal = in.nextLine();
            int[] AIProcessors = StringUtils.stringToArr(strVal.substring(1, strVal.length() - 1), ",");
            for (int i : AIProcessors) {
                List<Integer> integerList = map.get(i / 4);
                if (integerList == null) {
                    integerList = new ArrayList<>();
                }
                integerList.add(i);
                map.put(i/4, integerList);
            }
            int applyNum = in.nextInt();
            solution(AIProcessors, applyNum);
            System.out.println(listList.toString());
        }
    }

    private static void getProceors(List<Integer> processors, int num, int start, List<Integer> res) {
        if (num == 0) {
            if (res.size() != 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < res.size(); i++) {
                    list.add(res.get(i));
                }
               listList.add(list);
            }
            return;
        }

        for (int i = start; i < processors.size(); i++) {
            res.add(processors.get(i));
            getProceors(processors, num - 1, i + 1,res);
            res.remove(processors.get(i));
        }
    }


    private static void solution(int[] processors, int applyNum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> num1 = map.get(0);
        List<Integer> num2 = map.get(1);
        List<Integer> res = new ArrayList<>();
        if (applyNum == 1) {
            if (num1 == null) {
                if (num2 != null) {
                    getProceors(num2, applyNum, 0, res);
                }
            } else {
                if (num2 == null) {
                    getProceors(num1, applyNum, 0, res);
                } else {
                    if (num1.size() == num2.size()) {
                        getProceors(num2, applyNum, 0, res);
                        getProceors(num1, applyNum, 0, res);
                    } else {
                        if ((num1.size() % 2 != 0 && num2.size() % 2 == 0)
                            || (num1.size() % 2 != 0 && num2.size() % 2 != 0 && num1.size() < num2.size())
                            || (num1.size() % 2 == 0 && num2.size() % 2 == 0 && num1.size() < num2.size())) {
                            getProceors(num1, applyNum, 0, res);
                        } else {
                            getProceors(num2, applyNum, 0, res);
                        }
                    }
                }
            }
        } else if (applyNum == 2) {
            if (num1 == null) {
                if (num2 != null) {
                    getProceors(num2, applyNum, 0, res);
                }
            } else {
                if (num2 == null) {
                    getProceors(num1, applyNum, 0, res);
                } else {
                    if (num1.size() == num2.size()) {
                        getProceors(num2, applyNum, 0, res);
                        getProceors(num1, applyNum, 0, res);
                    } else {
                        if ((num1.size() % 2 == 0 && num2.size() % 2 != 0)
                            || (num1.size() % 2 == 0 && num2.size() % 2 == 0 && num1.size() < num2.size())) {
                            getProceors(num1, applyNum, 0, res);
                        } else {
                            getProceors(num2, applyNum, 0, res);
                        }
                    }
                }
            }
        } else if (applyNum == 4) {
            if (num1.size() == 4) {
                for (int i = 0; i < num1.size(); i++) {
                    res.add(num1.get(i));
                }
                if (num2.size() == 4) {
                    for (int i = 0; i < num2.size(); i++) {
                        res.add(num2.get(i));
                    }
                }
            }
        } else {
            if (num1.size() == 4 && num2.size() == 4) {
                for (int i = 0; i < num1.size(); i++) {
                    res.add(num1.get(i));
                }
                for (int i = 0; i < num2.size(); i++) {
                    res.add(num2.get(i));
                }
                listList.add(res);
            }
        }
    }
}