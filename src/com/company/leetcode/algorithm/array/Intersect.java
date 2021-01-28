package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.*;

/**
 * LC 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 说明：
 * *输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * * 我们可以不考虑输出结果的顺序。
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
        Log.o("first Method: ");
        Log.o(intersect1(origin1, origin2), -1, -1);
        Log.o("second Method: ");
        Log.o(intersect2(origin1, origin2), -1, -1);

    }

    private int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        int lastJStartIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = lastJStartIndex; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    nums2[j] = Integer.MAX_VALUE;
                    lastJStartIndex = j;
                    resultList.add(nums1[i]);
                    break;
                }
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer integer : resultList) {
            result[i++] = integer;
        }
        return result;
    }

    private int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Integer numSize;
        for (int num : nums1) {
            numSize = nums1Map.get(num);
            nums1Map.put(num, numSize != null ? numSize + 1 : 1);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            numSize = nums1Map.get(num);
            if (numSize != null && numSize != 0) {
                nums1Map.put(num, numSize - 1);
                resultList.add(num);
            }
        }
        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer integer : resultList) {
            result[i++] = integer;
        }
        return result;
    }
}
