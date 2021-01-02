package com.company.leetcode.algorithm.list;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * time: 2020-12-28
 */
public class AddTwoNumbers implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("两数相加:" + getClass().getSimpleName());

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));// 2 4 3
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(1))));//5 6 4

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        Log.oln("l1：   " + l1.toString());
        Log.oln("l2：   " + l2.toString());
        Log.oln("result:" + result.toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode nextNode = new ListNode();
        result.next = nextNode;
        int carry = 0;
        int currentValue;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode();
            currentValue = l1.val + l2.val + carry;
            carry = currentValue / 10;
            temp.val = currentValue % 10;
            l1 = l1.next;
            l2 = l2.next;
            nextNode.next = temp;
            nextNode = nextNode.next;
        }
        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            if (carry == 0) {
                nextNode.next = l1;
                break;
            }
            ListNode temp = new ListNode();
            currentValue = l1.val + carry;
            carry = currentValue / 10;
            temp.val = currentValue % 10;
            l1 = l1.next;
            nextNode.next = temp;
            nextNode = nextNode.next;
        }
        if (carry != 0) {
            nextNode.next = new ListNode(carry);
        }
        return result.next.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String str = "";
            ListNode temp = this;
            while (temp != null) {
                str = str + " " + temp.val;
                temp = temp.next;
            }
            return str;
        }
    }
}
