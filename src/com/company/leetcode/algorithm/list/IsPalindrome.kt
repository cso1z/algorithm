package com.company.leetcode.algorithm.list

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * time:2021.06.02
 */
class IsPalindrome() : AlgorithmInterface {
    override fun initData() {
        Log.oln("回文链表:" + javaClass.simpleName)
        val data = arrayOf(1, 2, 3, 2, 1)
        val originNode = ListHelper.getInstance().arrayToList(data)
        ListHelper.getInstance().printNodeList(originNode)

        Log.wrap()
    }
}