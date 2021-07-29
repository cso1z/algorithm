package com.company.leetcode.algorithm.array

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * LC 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm77tm/
 * time:2021-07-29
 */
class MajorityElement : AlgorithmInterface {

    override fun initData() {
        Log.oln("LC 多数元素:" + javaClass.simpleName)
        val origin = intArrayOf(3, 3, 4)
        Log.o("原始数据：")
        Log.o(origin, 0, origin.size)
        Log.o("结果:${majorityElement(origin)}")
        Log.wrap()
    }

    private fun majorityElement(nums: IntArray): Int {
        var count = 1
        var major: Int = nums[0]
        for (index in 1 until nums.size) {
            if (count == 0) {
                count++
                major = nums[index]
            } else if (major == nums[index]) {
                count++
            } else {
                count--
            }
        }
        return major
    }
}