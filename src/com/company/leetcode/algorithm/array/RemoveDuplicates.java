package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * time: 2020-12-27
 */
public class RemoveDuplicates implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("删除排序数组中的重复项:" + getClass().getSimpleName());

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] origin = new int[]{1, 1, 1, 2, 3, 3, 4, 5, 5, 5, 5};

        Log.o("原始数据：");
        Log.o(origin, -1, -1);

        int endIndex = removeDuplicates.removeDuplicates(origin);

        Log.o("结果: ");
        Log.o(origin, 0, endIndex);
    }

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
