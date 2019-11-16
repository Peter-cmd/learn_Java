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


    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        //处理树为空的情况
        if (root == null){
            return result;
        }

        //遍历左子树
        result.addAll(inorderTraversal(root.left));
        //当前节点为根节点
        result.add(root.val);
        //遍历右子树
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        //处理树为空的情况
        if (root == null){
            return result;
        }

        //遍历左子树
        result.addAll(postorderTraversal(root.left));
        //遍历右子树
        result.addAll(postorderTraversal(root.right));
        //当前节点
        result.add(root.val);
        return result;
    }

    //另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //处理树为空的情况
        if (s == null && t == null){
            return true;
        }
        //处理有一棵树为空的情况
        if (s == null || t == null){
            return false;
        }
        //处理一般情况
        boolean ret = false;
        if (s.val == t.val){
            ret = isSameTree(s,t);
        }
        //判断s的左子树是否包含t
        if (!ret){
            ret = isSubtree(s.left,t);
        }
        //判断s的右子树是否包含t
        if (!ret){
            ret = isSubtree(s.right,t);
        }

        return ret;
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
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }
}
