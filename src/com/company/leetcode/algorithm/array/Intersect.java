package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * time:2020.01.22
 */
public class Intersect implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("两个数组的交集 II" + getClass().getSimpleName());
        int[] origin1 = {4, 9, 5};
        int[] origin2 = {9, 4, 9, 8, 4};
        Log.o("数组1：");
        Log.o(origin1, -1, -1);
        Log.o("数组2：");
        Log.o(origin2, -1, -1);
    }

    private void intersect1(int[] nums1, int[] nums2) {
        int[] result = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

            }
        }
    }

    private void intersect2(int[] nums1, int[] nums2) {
        int length = Math.min(nums1.length, nums2.length);
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            resultSet.add(nums1[i]);
        }
    }
}
