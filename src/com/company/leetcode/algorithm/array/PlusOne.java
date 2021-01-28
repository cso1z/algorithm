package com.company.leetcode.algorithm.array;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;
import com.sun.deploy.util.ArrayUtil;

/**
 * LC 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * time:2021-01-28
 */
public class PlusOne implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("加一:" + getClass().getSimpleName());
        int[] origin1 = {9,9,9};
        int[] origin2 = {9,9,9};
        Log.o("原始数据：");
        Log.o(origin1, -1, -1);
        Log.o("first Method：");
        Log.o(plusOne1(origin1), -1, -1);
        Log.o("second Method：");
        Log.o(plusOne2(origin2), -1, -1);
    }

    public int[] plusOne1(int[] digits) {
        boolean isCarry = true;
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (isCarry) {
                temp = ++digits[i];
                digits[i] = temp % 10;
                isCarry = temp / 10 >= 1;
            }
        }
        if (isCarry) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        boolean isCarry = true;
        int temp;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (isCarry) {
                temp = ++digits[i];
                digits[i] = temp % 10;
                isCarry = temp / 10 >= 1;
            }
        }
        if (isCarry) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
