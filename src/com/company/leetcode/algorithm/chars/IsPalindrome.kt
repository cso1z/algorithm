package com.company.leetcode.algorithm.chars

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 * time:2021.06.09
 */
class IsPalindrome : AlgorithmInterface {
    override fun initData() {
        Log.oln("验证回文串:${javaClass.simpleName}")
        val data = "A man, a plan, a canal: Panama"
        Log.oln("$data ${if (isPalindrome(data)) "是" else "不是"} 回文串")
    }

    private fun isPalindrome(s: String): Boolean {
        var firstIndex = 0
        var endIndex = s.lastIndex
        while (firstIndex < endIndex) {
            if (!s[firstIndex].isLetter() || !s[firstIndex].isDigit()) {
                firstIndex++
                continue
            }
            if (!s[endIndex].isLetter() || !s[endIndex].isDigit()) {
                endIndex--
                continue
            }
            if (s[firstIndex].equals(s[endIndex], true)) {
                firstIndex++
                endIndex--
            } else {
                return false
            }
        }
        return true
    }
}