package com.company.leetcode.algorithm.tree;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * url:https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnd69e/
 * time:2021-05-21
 */
public class MaxDepth implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("二叉树的最大深度:" + getClass().getSimpleName());
        TreeNode treeNode = new TreeNode(1);
        TreeNode firstLeftDepthTree = new TreeNode(2);
        TreeNode firstRightDepthTree = new TreeNode(3);
        treeNode.left = firstLeftDepthTree;
        treeNode.right = firstRightDepthTree;
    }

    /**
     * 深度优先搜索
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
