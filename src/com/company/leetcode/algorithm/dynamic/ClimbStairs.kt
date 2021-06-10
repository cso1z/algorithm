package com.company.leetcode.algorithm.dynamic

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
 * time:2021.06.10
 */
class ClimbStairs : AlgorithmInterface {

    override fun initData() {
        Log.oln("爬楼梯:${javaClass.simpleName}")
        for (index in 1..4) {
            Log.oln("$index 层楼梯有${climbStairs(index)}种走法")
        }
    }

    private val map: MutableMap<Int, Int> = mutableMapOf()

    private fun climbStairs(n: Int): Int {
        return if (map.containsKey(n)) {
            map[n] ?: 0
        } else {
            val result = when (n) {
                1 -> 1
                2 -> 2
                else -> {
                    climbStairs(n - 1) + climbStairs(n - 2)
                }
            }
            map[n] = result
            result
        }
    }
}