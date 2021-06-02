package com.company.leetcode.algorithm.sundry;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * time:2021.06.02
 */
public class IsPowerOfFour implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("4的幂:" + getClass().getSimpleName());
        int data = -2147483648;

        Log.oln("min:" + Integer.MIN_VALUE);
        boolean result = isPowerOfFour(data);
        Log.oln("数字" + data + (result ? "是" : "不是") + "4 的幂");
    }
    //  String lowTemp = Integer.toBinaryString((bytes[4] & 0xff));

    //5    4   3    2  1  0
    //64  32   16   8  4  1

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        int index = 0;
        while (n > 0) {
            if ((n & 0B1) == 0B1) {
                if (index % 2 == 1 || count >= 1) {
                    return false;
                } else {
                    count++;
                }
            }
            index++;
            n = n >> 1;
        }
        return true;
    }


}