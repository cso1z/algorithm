package com.company.leetcode.algorithm.list;

import com.company.leetcode.algorithm.tree.TreeHelper;

public class ListHelper {
    static ListHelper helper;

    private ListHelper() {

    }

    public static synchronized ListHelper getInstance() {
        if (helper == null) {
            helper = new ListHelper();
        }
        return helper;
    }
}
