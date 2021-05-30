package com.company.leetcode.algorithm.list;

public class ListNode {
    public int val;
    public ListNode next;

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
