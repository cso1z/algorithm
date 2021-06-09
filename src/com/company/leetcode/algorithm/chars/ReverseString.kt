package com.company.leetcode.algorithm.chars

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 提示：你可以假定该字符串只包含小写字母。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * time:2021.06.09
 */
class ReverseString : AlgorithmInterface {

    override fun initData() {
        Log.oln("字符串中的第一个唯一字符:${javaClass.simpleName}")
        val data = "abcdefghijklmnopqrstuvwxyza"
        Log.oln("原始数据：$data")
        val result = firstUniqChar(data)
        Log.oln("第一个唯一字符位置为：$result")
    }


    fun firstUniqChar(s: String): Int {
        val map: MutableMap<Char, Int> = mutableMapOf()
        for ((index, item) in s.withIndex()) {
            if (map.containsKey(item)) {
                map.set(item, Int.MAX_VALUE)
            } else {
                map.put(item, index)
            }
        }
        return map.values.minOrNull() ?: -1
    }

}