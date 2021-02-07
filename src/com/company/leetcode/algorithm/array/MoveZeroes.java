package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * LC 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * Url：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * time:2021-02-07
 */
public class MoveZeroes implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("LC 移动零:" + getClass().getSimpleName());
        int[] origin1 = {0, 0, 1};
        int[] origin2 = {0, 0, 1};
        Log.o("原始数据：", origin1, -1, -1);
        moveZeroes1(origin1);
        Log.o("first method：", origin1, -1, -1);
        moveZeroes2(origin2);
        Log.o("second method：", origin2, -1, -1);
    }

    private void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    private void moveZeroes2(int[] nums) {
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (endIndex <= i) {
                    endIndex = i + 1;
                }
                for (int j = endIndex; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        endIndex = j;
                        break;
                    }
                }
            }
        }
    }
}
