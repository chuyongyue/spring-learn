package com.peerfintech.solution;

import java.util.Scanner;

/**
 * ThreadLocal
 */
public class Main1 {
    public static void main(String[] args) {
        ThreadLocal<Person> threadLocal = new ThreadLocal<>();
        threadLocal.set(new Person());
        threadLocal.remove();
    }
}
