package com.company.leetcode.algorithm.sundry;

import com.company.leetcode.interfac.AlgorithmInterface;

public class CheckSubarraySum implements AlgorithmInterface {
    @Override
    public void initData() {
        int[] data = {1, 2, 3, 4, 5, 6};
        int k = 4;

        checkSubarraySum(data, k);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int result;
        int j;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            result = k;
            j = i;
            while (j < size && result > 0) {
                result = result - nums[j];
                if (result % k == 0 && j - i > 1) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
