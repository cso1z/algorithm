package com.company.leetcode.utils;

public class Log {

    public static void o(Object o) {
        System.out.print(o.toString());
    }

    public static void oln(Object o) {
        System.out.println(o.toString());
    }

    public static void wrap() {
        System.out.println("");
    }

    public static void o(int[] list, int start, int end) {
        if (list == null) {
            return;
        }
        start = Math.max(start, 0);
        end = end < 0 ? list.length : end;
        for (int i = start; i < Math.min(list.length, end); i++) {
            o(list[i] + " ");
        }
        wrap();
    }

    public static void o(String tag, int[] list, int start, int end) {
        o(tag);
        if (list == null) {
            return;
        }
        start = Math.max(start, 0);
        end = end < 0 ? list.length : end;
        for (int i = start; i < Math.min(list.length, end); i++) {
            o(list[i] + " ");
        }
        wrap();
    }
}
