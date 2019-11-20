package test02;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Mian {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        //构造函数
        public TreeNode(int val){
            this.val = val;
        }
    }

    //层次遍历
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return result;
        }
        helper(root,0);  //调用辅助函数
        return result;
    }

    //辅助函数,辅助完成层次遍历
    private void helper(TreeNode root, int level){
        //若level层还未有元素
        if (result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        //将访问到的值加入相应的下标数组中
        result.get(level).add(root.val);
        //若左子树不为空
        if (root.left != null){
            helper(root.left, level + 1);
        }
        //若右子树不为空
        if (root.right != null){
            helper(root.right, level + 1);
        }
    }

    //二叉树的最近公共祖先
    private static TreeNode lca = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        //处理树为空的情况
        if (root == null){
            return null;
        }

        findNode(root,p,q);
        return lca;
    }

    //找到p 或 q 的方法
    public static boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        //若树为空
        if (root == null){
            return false;
        }
        //递归尝试在左子树中找 p 或 q
        int left = findNode(root.left,p,q) ? 1 : 0;
        //递归尝试在右子树中找 p 或 q
        int right = findNode(root.right,p,q) ? 1 : 0;
        //判断当前节点是否找到
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2){
            lca = root;
        }
        return (left + right + mid > 0);
    }

    //非递归实现前序遍历二叉树
    public static void preOrderTree(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        //前序遍历二叉树
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //若栈不为空
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (root.left != null){
                stack.add(root.left);
            }
            if (root.right != null){
                stack.add(root.right);
            }
        }
    }

    //将二叉搜索树转换成双向排序链表
    public static TreeNode convert(TreeNode pRootOfTree){
        //处理树为空的情况
        if (pRootOfTree == null){
            return null;
        }
        //处理只有一个节点的情况
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //遍历左子树得到左子树中链表的头结点
        TreeNode left = convert(pRootOfTree.left);
        TreeNode leftTail = left;
        //找到链表末尾元素
        while (leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //将当前节点插入链表的末尾
        if (left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //遍历右子树得到右子树中链表的头结点
        TreeNode right = convert(pRootOfTree.right);
        //将当前节点插入链表的末尾
        if (right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return (left == null) ? pRootOfTree : left;
    }

    //
    public static void main(String[] args){

    }
}
