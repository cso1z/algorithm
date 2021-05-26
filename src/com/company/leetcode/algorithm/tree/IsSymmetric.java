package com.company.leetcode.algorithm.tree;

import com.company.leetcode.interfac.AlgorithmInterface;
import com.company.leetcode.utils.Log;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * time:2021.05.26
 */
public class IsSymmetric implements AlgorithmInterface {
    @Override
    public void initData() {
        Log.oln("对称二叉树" + getClass().getSimpleName());
        Integer[] data = {1, 2, 2, null, 3, null, 3};
        TreeNode root = TreeHelper.getInstance().arrayToTree(data);
        TreeHelper.getInstance().printTree(root);
        Log.wrap();
        Log.oln("结果：" + (isSymmetric(root) ? "是" : "不是") + "对称二叉树");
    }

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        //都为null  return true
        if (left == null && right == null) {
            return true;
        }
        //仅有一个为null  return false
        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }
        //都不为null 比较value
        if (left.val != right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
}