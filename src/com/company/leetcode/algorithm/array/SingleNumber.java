package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * time: 2021-01-28
 */
public class SingleNumber implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("只出现一次的数字:" + getClass().getSimpleName());
        int[] origin = {2, 2, 1};
        Log.o("原始数据：");
        Log.o(origin, -1, -1);
        Log.oln("first Method：" + singleNumber1(origin));
        Log.oln("second Method：" + singleNumber2(origin));

    }

    public int singleNumber1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index;
        for (int num : nums) {
            index = list.indexOf(num);
            if (index == -1) {
                list.add(num);
            } else {
                list.remove(index);
            }
        }
        return list.get(0);
    }

    public int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
