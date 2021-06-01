package com.company.leetcode.algorithm.list;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
 * time:2021.05.28
 */
public class DeleteNode implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("删除链表中的节点:" + getClass().getSimpleName());
        Integer[] data = {1, 2, 3, 4, 5, 6, 7};
        ListNode headNode = ListHelper.getInstance().arrayToList(data);

        Log.o("原始数据：");
        ListHelper.getInstance().printNodeList(headNode);

        ListNode deleteNode = headNode.next.next.next;

        Log.o("\n删除Node:" + deleteNode.val);

        deleteNode(deleteNode);

        Log.o("\n结果：");
        ListHelper.getInstance().printNodeList(headNode);
        Log.wrap();
    }

    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
