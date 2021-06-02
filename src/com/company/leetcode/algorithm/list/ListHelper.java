package com.company.leetcode.algorithm.list;

import com.company.leetcode.algorithm.tree.TreeHelper;
import com.company.leetcode.algorithm.tree.TreeNode;
import com.company.leetcode.utils.Log;

import java.util.List;

public class ListHelper {
    private static ListHelper helper;

    private ListHelper() {

    }

    public static synchronized ListHelper getInstance() {
        if (helper == null) {
            helper = new ListHelper();
        }
        return helper;
    }

    public ListNode arrayToList(Integer[] array) {
        ListNode headNode = new ListNode();
        ListNode currentNode;
        if (array != null && array.length > 0) {
            headNode.val = array[0];
            currentNode = headNode;
            ListNode tempNode;
            for (int i = 1; i < array.length; i++) {
                tempNode = new ListNode();
                tempNode.val = array[i];
                currentNode.next = tempNode;
                currentNode = tempNode;
            }
        }
        return headNode;
    }

    public void printNodeList(ListNode headNode) {
        ListNode currentNode = headNode;
        while (currentNode != null) {
            Log.o(currentNode.val + " ");
            currentNode = currentNode.next;
        }
    }

    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
