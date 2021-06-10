package com.company.leetcode.algorithm.dynamic

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnq4km/
 * time:2021.06.10
 */
class Rob : AlgorithmInterface {

    override fun initData() {
        Log.oln("打家劫舍:${javaClass.simpleName}")
        val data = intArrayOf(2, 7, 9, 3, 1)
        Log.o(data, -1, -1)
        Log.oln("最大值为:${rob(data)}")
    }

    private fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val list = IntArray(nums.size)
        list[0] = nums[0]
        list[1] = maxOf(nums[0], nums[1])
        var max = maxOf(list[0], list[1])
        for (index in 2 until nums.size) {
            list[index] = maxOf((list[index - 2] + nums[index]), list[index - 1])
            max = maxOf(list[index], max)
        }
        return max
    }
}