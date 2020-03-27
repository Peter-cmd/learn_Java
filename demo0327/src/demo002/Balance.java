package demo002;


/**
 问题描述: 实现一个函数,检查二叉树是否平衡,平衡的定义如下,对于树中的任意有一个
 结点,其两棵子树的高度差不超过1.
 给定指向树根结点的指针TreeNode* root, 请返回一个bool,代表这棵树是否平衡.
 */

import java.util.*;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Balance {
    public boolean isBalance(TreeNode root) {
        // write code here

        if (root == null){
            return true;
        }

        int left = count(root.left);
        int right = count(root.right);

        return left > right? left - right <= 1 : right - left <= 1;
    }

    public static int count(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = count(root.left) + 1;
        int right = count(root.right) + 1;

        return left > right ? left : right;
    }
}