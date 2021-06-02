package com.company.leetcode.algorithm.list

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log


/**
 * 反转链表
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 * time:2021.06.02
 */
class ReverseList() : AlgorithmInterface {

    override fun initData() {
        Log.oln("反转链表:" + javaClass.simpleName)
        val data = arrayOf(1, 2, 3)
        val dataNode = ListHelper.getInstance().arrayToList(data)
        Log.o("原始数据：")
        ListHelper.getInstance().printNodeList(dataNode)
        Log.wrap()
        val resultNode = reverseList2(dataNode)
        Log.o("反转后数据：")
        ListHelper.getInstance().printNodeList(resultNode)
        Log.wrap()
    }

    //通过构造节点
    private fun reverseList(head: ListNode?): ListNode? {
        var head = head;
        var resultNode: ListNode? = null
        var lastNode: ListNode? = null
        while (head != null) {
            if (resultNode == null) {
                resultNode = ListNode(head.`val`, null)
                lastNode = resultNode
            } else {
                val node = ListNode(head.`val`, lastNode)
                lastNode = node
            }
            head = head.next
        }
        return lastNode
    }


    //通过移动指针
    private fun reverseList2(head: ListNode?): ListNode? {
        var head = head;
        var nextNode: ListNode?
        var lastNode: ListNode? = null
        while (head != null) {
            nextNode = head.next
            head.next = lastNode
            lastNode = head
            head = nextNode
        }
        return lastNode
    }
}