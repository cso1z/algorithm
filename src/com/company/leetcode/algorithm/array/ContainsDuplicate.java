package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * url：https://leetcode-cn.com/problems/contains-duplicate/
 * time:2021-01-18
 */
public class ContainsDuplicate implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("存在重复元素:" + getClass().getSimpleName());
        int[] origin = {1};
        Log.o("原始数据：");
        Log.o(origin, -1, -1);
        Log.oln("結果：" + containsDuplicate(origin));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!resultSet.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
