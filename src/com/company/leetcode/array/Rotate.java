package com.company.leetcode.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * url: https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * time: 2020-12-27
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        rotate1(nums, k);
        rotate2(nums, k);
    }

    public void rotate1(int[] nums, int k) {
        System.out.println("First Method");
        int length = nums.length;
        int reallyRotateTime = k % length;
        int currentValue;
        for (int i = 0; i < reallyRotateTime; i++) {
            int currentMoveIndex = length - 1;
            currentValue = nums[currentMoveIndex];
            System.arraycopy(nums, 0, nums, 1, currentMoveIndex);
            nums[0] = currentValue;
        }
    }

    public void rotate2(int[] nums, int k) {
        System.out.println("Second Method");
        int length = nums.length;
        int reallyRotateTime = k % length;
        int splitIndex = length - reallyRotateTime;
        int goalIndex = splitIndex - 1;
        int startIndex = goalIndex;
        int temp1 = nums[goalIndex];
        int temp2;
        for (int i = 0; i < length; i++) {
            if (goalIndex < length - reallyRotateTime) {
                goalIndex = length - (splitIndex - goalIndex);
            } else {
                goalIndex = goalIndex - splitIndex;
            }
            temp2 = nums[goalIndex];
            nums[goalIndex] = temp1;
            temp1 = temp2;
            if (goalIndex == startIndex && i < length - 1) {
                startIndex = startIndex - 1;
                goalIndex = startIndex;
                temp1 = nums[goalIndex];
            }
        }
    }

    public void rotate3(int[] nums, int k) {
        System.out.println("Third Method");
        int length = nums.length;
        int reallyRotateTime = k % length;
        reverse(nums, 0, length - reallyRotateTime);
        reverse(nums, length - reallyRotateTime, length);
        reverse(nums, 0, length);
    }

    //翻转数组
    private void reverse(int[] arrays, int start, int end) {
        int length = end - start;
        int temp;
        for (int i = 0; i < length / 2; i++) {
            temp = arrays[start + i];
            arrays[start + i] = arrays[end - i - 1];
            arrays[end - i - 1] = temp;
        }
    }
}
