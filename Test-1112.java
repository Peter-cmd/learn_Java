package test;

import sun.reflect.generics.tree.Tree;

import java.util.*;

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

    //树的深度
    public int maxDepth(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return 0;
        }
        //处理只有一个节点的情况
        if (root.left == null && root.right == null){
            return 1;
        }
        //左子树的深度
        int depthLeft = maxDepth(root.left);
        //右子树的深度
        int depthRight = maxDepth(root.right);

        return 1 + (depthLeft > depthRight ? depthLeft : depthRight);

    }

    //判断一棵二叉树是不是平衡二叉树
    public boolean isBalancedTree(TreeNode root){
        //如果树为空或没有子树,算平衡
        if (root == null || root.left == null && root.right == null){
            return true;
        }

        //判断左右子树的差值是否为1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        //若左右子树的差值大于1
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1){
            return false;
        }

        return isBalancedTree(root.left) && isBalancedTree(root.right);

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

    //判断对称二叉树
    public boolean isSymmtry(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return true;
        }

        return isMirror(root.left,root.right);
    }

    //判断两棵树是否是镜像关系
    public boolean isMirror(TreeNode t1, TreeNode t2){
        //处理两棵树都为空的情况
        if (t1 == null && t2 == null){
            return true;
        }
        //处理有一棵树为空的情况
        if (t1 == null || t2 == null){
            return false;
        }
        //判断根节点是否相等
        if (t1.val != t2.val){
            return false;
        }

        return isMirror(t1.left,t2.right)
                && isMirror(t1.right,t2.left);
    }

    //层序遍历
    public void levelOrder(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        //树不为空
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //将根节点插入queue
        while (!queue.isEmpty()){
            //获取队首元素
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            //若左子树不为空
            if (cur.left != null){
                 queue.add(cur.left);
            }
            //若右子树不为空
            if(cur.right != null){
                queue.add(cur.right);
            }

        }

    }

    //非递归中序遍历二叉树
    public void inOrder(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack =  new Stack<>();
        //变量cur从根节点出发
        TreeNode cur = root;
        while (true){
            //若cur不等于空,cur进栈,cur指向cur.left
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //若栈为空
            if (stack.isEmpty()){
                break;
            }
            //获取栈顶元素
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }

    }

    //非递归二叉树的后序遍历
    public void postOrder(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        //变量 cur 从 root 开始遍历
        TreeNode cur = root;
        //prev 始终指向上一次访问的节点
        TreeNode prev = null;

        while (true){
            //循环找左子树直到cur等于空
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //判断栈是否为空
            if (stack.isEmpty()){
                break;
            }
            //判定栈顶元素是否可以出栈有两种情况
            //1.该元素的右子树为空
            //2.该元素的右子树已经被访问过了
            TreeNode top = stack.peek();
            if (top.right == null || prev == top.right){
                System.out.print(top.val + " ");
                prev = top;
                //栈顶元素出栈
                stack.pop();

            }else{
                cur = top.right;
            }
        }
    }

    //根据前序和中序序列,构建二叉树
    private int index = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        index = 0;
        return buildTreeHelper(preOrder,inOrder,0,inOrder.length);
    }

    //辅助构建二叉树
    public TreeNode buildTreeHelper(int[] preOrder, int[] inOrder,
                                    int inOrderLeft, int inOrderRight){
        //若inOrderLeft大于inOrderRight,则该数为空
        if (inOrderLeft >= inOrderRight){
            return null;
        }

        if (index >= preOrder.length){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[index]);
        index++;
        //在inOrder中找与该节点值想等的值
        int pos = find(inOrder,inOrderLeft,inOrderRight,root.val);
        root.left = buildTreeHelper(preOrder,inOrder,inOrderLeft,pos);
        root.right = buildTreeHelper(preOrder,inOrder,pos + 1,inOrderRight);
        return root;
    }

    //查找val在中序序列中的位置
    private int find(int[] inOrder,int inOrderLeft, int inOrderRight, int val){

        for (int i = inOrderLeft; i < inOrderRight; i++){
            if (inOrder[i] == val){
                return i;
            }
        }
        return -1;
    }
    //判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        //若树为空
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        //若队列不为空
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            //若取得元素为空
            if (curNode == null){
                flag = true;
                continue;
            }
            //若当前节点不为空,且false为true
            if (flag){
                return false;
            }
            queue.add(curNode.left);
            queue.add(curNode.right);
        }
        return true;
    }

    //用以保存要返回的字符串
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode root){
        //处理树为空的情况
        if (root == null){
            return " ";
        }
        //调用辅助方法
        tree2strHelper(root);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void tree2strHelper(TreeNode root){
        if (root == null){
            return;
        }

        stringBuilder.append("(");
        stringBuilder.append(root.val);
        tree2strHelper(root.left);
        if (root.left == null && root.right != null){
            stringBuilder.append("( )");
        }
        tree2strHelper(root.right);
        stringBuilder.append(")");
    }
        //主方法
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = build();
        Test test = new Test();
        list = test.preorderTraversal(root);
        System.out.println(list);
        int ret = test.maxDepth(root);
        System.out.println(ret);
        System.out.println(test.isBalancedTree(root));
        System.out.println(test.isSymmtry(root));
        test.levelOrder(root);
        System.out.println();
        System.out.println(test.isCompleteTree(root));
        test.inOrder(root);
        System.out.println();
        test.postOrder(root);
        System.out.println();
        System.out.println(test.tree2str(root));
        test.buildTree(preOrder,inOrder);

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
