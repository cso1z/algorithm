package com.company.leetcode.algorithm.sundry;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * time:2021.01.19
 */
public class Reverse implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("整数反转" + getClass().getSimpleName());
        int origin = 1534236469;
        Log.oln("原始数据：" + origin);
        int result = reverse(origin);
        Log.oln("结果：" + result);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 0;
        while (x != 0) {
            if (result * 10 + x % 10 <= Integer.MAX_VALUE - 1 && result >= Integer.MIN_VALUE + 1) {
                result = result * 10 + x % 10;
            } else {
                return 0;
            }
            Log.oln(result);
            x = x / 10;
        }
        return result;
    }
}