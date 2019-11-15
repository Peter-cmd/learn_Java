package test;


import java.util.ArrayList;
import java.util.List;

public class Test {
    //内部类
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        //处理树为空的情况
        if (root == null){
            return result;
        }

        //当前节点为根节点
        result.add(root.val);
        //遍历左子树
        result.addAll(preorderTraversal(root.left));
        //遍历右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //创建一个树
    public static TreeNode build(){
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        return A;
    }

    //主方法
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        TreeNode root = build();
        Test test = new Test();
        list = test.preorderTraversal(root);
        System.out.println(list);

    }
    //判断两树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //若两树为空
        if (p == null && q == null){
            return true;
        }
        //若有一棵树为空
        if (p == null || q == null){
            return false;
        }
        //比较两棵树的根节点的值
        if (p.val == q.val){
            return false;
        }
        return isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }
}
