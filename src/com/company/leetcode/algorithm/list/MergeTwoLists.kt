package com.company.leetcode.algorithm.list

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
 * time:2021.06.02
 */
class MergeTwoLists() : AlgorithmInterface {
    override fun initData() {
        Log.oln("合并两个有序链表：" + javaClass.simpleName)
        val data1 = arrayOf(1, 3, 5, 7, 8, 9)
        val data2 = arrayOf(2, 4, 6)

        //需要合并的list
        val node1: ListNode = ListHelper.getInstance().arrayToList(data1)
        val node2 = ListHelper.getInstance().arrayToList(data2)
        Log.o("数据1：")
        ListHelper.getInstance().printNodeList(node1)
        Log.o("\n数据2：")
        ListHelper.getInstance().printNodeList(node2)
        //合并
        val resultNode: ListNode? = mergeTwoLists(node1, node2)

        Log.o("\n结果：")
        ListHelper.getInstance().printNodeList(resultNode)
        Log.wrap()
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var resultNode: ListNode? = null
        var lastNode: ListNode? = null
        var currentNode1: ListNode? = l1
        var currentNode2: ListNode? = l2
        while (currentNode1 != null && currentNode2 != null) {
            if (resultNode == null) {
                //第一次
                if (currentNode1.`val` < currentNode2.`val`) {
                    resultNode = currentNode1
                    currentNode1 = currentNode1.next
                } else {
                    resultNode = currentNode2
                    currentNode2 = currentNode2.next
                }
                lastNode = resultNode
            } else {
                if (currentNode1.`val` < currentNode2.`val`) {
                    if (lastNode != null) {
                        lastNode.next = currentNode1
                    }
                    currentNode1 = currentNode1.next
                } else {
                    if (lastNode != null) {
                        lastNode.next = currentNode2
                    }
                    currentNode2 = currentNode2.next
                }
                if (lastNode != null) {
                    lastNode = lastNode.next
                }
            }
        }
        //是否还有一个链表有值
        if (resultNode == null) {
            resultNode = currentNode1 ?: currentNode2
        } else {
            if (currentNode1 != null) {
                if (lastNode != null) {
                    lastNode.next = currentNode1
                }
            } else if (currentNode2 != null) {
                if (lastNode != null) {
                    lastNode.next = currentNode2
                }
            }
        }
        return resultNode
    }
}