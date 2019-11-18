package test01;

import java.util.Scanner;

public class Main01 {
    //二叉树的节点
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val){
            this.val = val;
        }
    }

    //创建一棵树
    static int index = 0;
    public static TreeNode buildTree(String line){
        index = 0;
        return createTreePreOrder(line);
    }

    //前序创建一棵树
    public static TreeNode createTreePreOrder(String line){
        char c = line.charAt(index);
        //若为#放回null
        if (c == '#') {
            return null;
        }

        TreeNode root = new TreeNode(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;

    }

    //中序遍历树
    public static void inOrderTraverse(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return;
        }

        inOrderTraverse(root.left);
        System.out.print(root.val + " ");
        inOrderTraverse(root.right);
    }



    //主方法
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            String line = in.next();
            TreeNode root = buildTree(line);
            inOrderTraverse(root);
        }
    }

}
