package com.company.leetcode.algorithm.chars

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * time:2021.06.09
 */
class IsAnagram : AlgorithmInterface {

    override fun initData() {
        Log.oln("有效的字母异位词:${javaClass.simpleName}")
        val data1 = "abcdefgf"
        val data2 = "gfedcbaa"
        Log.oln("第一个字符串：$data1  第二个字符串：$data2")
        Log.oln("结果：${isAnagram(data1, data2)}")
    }

    private fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val map: MutableMap<Char, Int> = mutableMapOf()
        for (index in s.indices) {
            if (map.containsKey(s[index])) {
                map[s[index]] = map.getValue(s[index]) + 1
            } else {
                map[s[index]] = 1
            }
            if (map.containsKey(t[index])) {
                map[t[index]] = map.getValue(t[index]) - 1
            } else {
                map[t[index]] = -1
            }
        }
        return map.all { it.value == 0 }
    }

}