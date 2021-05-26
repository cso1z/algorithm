package com.company.leetcode.algorithm.tree;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
 * time:2021.05.21
 */
public class IsValidBST implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("验证二叉搜索树:" + getClass().getSimpleName());
        TreeNode treeNode = new TreeNode(1);
        TreeNode firstLeftDepthTree = new TreeNode(2);
        TreeNode firstRightDepthTree = new TreeNode(3);
        treeNode.left = firstLeftDepthTree;
        treeNode.right = firstRightDepthTree;
        isValidBST(treeNode);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastValue != null && lastValue > root.val) {
            return false;
        }
        lastValue = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    Integer lastValue = null;


}
