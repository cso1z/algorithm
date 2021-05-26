package com.company.leetcode.algorithm.tree;

import com.company.leetcode.utils.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeHelper {
    static TreeHelper helper;

    private TreeHelper() {

    }

    public static synchronized TreeHelper getInstance() {
        if (helper == null) {
            helper = new TreeHelper();
        }
        return helper;
    }

    public TreeNode arrayToTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);

                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);

                }
                queue.poll();
                isLeft = true;

            }
        }
        return root;
    }

    public TreeNode createTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createTreeByArray(array, 2 * index + 1);
            tn.right = createTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

    /**
     * 中序遍历
     */
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        Log.o(root.val + "  ");
        printTree(root.right);
    }


}
