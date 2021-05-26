package com.company.leetcode.algorithm.tree;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * time:2021.05.26
 */
public class SortedArrayToBST implements AlgorithmInterface {

    @Override
    public void initData() {
        Log.oln("将有序数组转换为二叉搜索树:" + getClass().getSimpleName());
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode node = sortedArrayToBST(data);
        TreeHelper.getInstance().printTree(node);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        int currentIndex = nums.length / 2;
        root.val = nums[currentIndex];
        if (currentIndex > 0) {
            root.left = sortedArrayToBST(nums, 0, currentIndex - 1);
        }
        if (currentIndex < nums.length - 1) {
            root.right = sortedArrayToBST(nums, currentIndex + 1, nums.length - 1);
        }
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        TreeNode root = new TreeNode();
        int currentIndex = (end - start) / 2 + start;
        root.val = nums[currentIndex];
        if (currentIndex > start) {
            root.left = sortedArrayToBST(nums, start, currentIndex - 1);
        }
        if (currentIndex < end) {
            root.right = sortedArrayToBST(nums, currentIndex + 1, end);
        }
        return root;
    }
}
