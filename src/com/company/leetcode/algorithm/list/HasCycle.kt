package com.company.leetcode.algorithm.list

import com.company.leetcode.interfac.AlgorithmInterface
import com.company.leetcode.utils.Log

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引
 *
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnwzei/
 * time:2021.06.04
 */
class HasCycle : AlgorithmInterface {
    override fun initData() {
        Log.oln("环形链表：" + javaClass.simpleName)
        val data = arrayOf(1, 2, 3, 2, 1)
        val originNode = ListHelper.getInstance().arrayToList(data)
    }

    fun hasCycle(head: ListNode?): Boolean {
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (slow != null && fast != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow != null && fast != null && fast == slow) {
                return true
            }
        }
        return false
    }
}