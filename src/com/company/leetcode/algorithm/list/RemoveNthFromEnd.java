package com.company.leetcode.algorithm.list;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * Url：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * time：2021.05.30
 */
public class RemoveNthFromEnd implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("删除链表的倒数第N个节点:" + getClass().getSimpleName());
        Integer[] data = {1, 2, 3};
        ListNode dataNode = ListHelper.getInstance().arrayToList(data);

        Log.o("原始数据：");
        ListHelper.getInstance().printNodeList(dataNode);
        Log.wrap();

        int i = 3;
        Log.o(String.format("删除倒数第%d个节点：", i));

        ListNode resultNode = removeNthFromEnd(dataNode, i);

        ListHelper.getInstance().printNodeList(resultNode);
        Log.wrap();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointerNode = head;
        ListNode nthNode = head;
        int index = 0;
        while (pointerNode != null) {
            pointerNode = pointerNode.next;
            index++;
            if (index > n + 1) {
                nthNode = nthNode.next;
            }
        }
        if (index >= n + 1) {
            nthNode.next = nthNode.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}