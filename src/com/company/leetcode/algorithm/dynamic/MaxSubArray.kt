package com.company.leetcode.algorithm.dynamic

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
 * time:2021.06.10
 */
class MaxSubArray : AlgorithmInterface {

    override fun initData() {
        Log.oln("最大子序和:${javaClass.simpleName}")
        val nums: IntArray = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        Log.o("数据：")
        Log.o(nums, -1, -1)
        Log.oln("最大值：${maxSubArray(nums)}")
    }

    private fun maxSubArray(nums: IntArray): Int {
        val subResult = IntArray(nums.size) { 0 }
        subResult[0] = nums[0]
        for (index in 1 until nums.size) {
            subResult[index] = nums[index] + maxOf(subResult[index - 1], 0)
        }
        return subResult.maxOf { it }
    }

}