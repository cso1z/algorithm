package com.company.leetcode.algorithm.tree;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 * time:2021.05.26
 */
public class LevelOrder implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("二叉树的层序遍历:" + getClass().getSimpleName());
        Integer[] data = {1, 2, 2, null, 3, null, 3};
        TreeNode root = TreeHelper.getInstance().arrayToTree(data);
        TreeHelper.getInstance().printTree(root);
        Log.wrap();
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> item : lists) {
            Log.oln(item);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            lists.add(levelList);
        }
        return lists;
    }
}
