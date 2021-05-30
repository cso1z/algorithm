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
    }

    public void deleteNode(ListNode node) {

    }
}
