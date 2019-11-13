package Test;
//节点类
class Node{
    private char var;
    private Node left;
    private Node right;

    //构造函数
    public Node(char var){
        this.var = var;
        this.left = null;
        this.right = null;
    }

    public char getVar() {
        return var;
    }

    public void setVar(char var) {
        this.var = var;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

//二叉树
public class BinaryTree {

    //根节点
    private static Node root = null;

    //创建二叉树
    public static Node build(){

        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');

        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(E);
        C.setLeft(F);
        C.setRight(G);

        return A;
    }

    //前序遍历
    public static void prevOrder(Node root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        System.out.print(root.getVar());
        prevOrder(root.getLeft());
        prevOrder(root.getRight());
    }

    //中序遍历
    public static void inOrder(Node root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getVar());
        inOrder(root.getRight());
    }

    //后序遍历
    public static void postOrder(Node root){
        //处理树为空的情况
        if (root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getVar());
    }

    //求二叉树节点个数
    public static int numberOfNode(Node root){
        //处理树为空的情况
        if (root == null){
            return 0;
        }

        return 1 + numberOfNode(root.getLeft()) + numberOfNode(root.getRight());
    }

    // 求二叉树中叶子节点的个数
    public static int numberOfLeafNode(Node root){
        //处理树为空的情况
        if (root == null){
            return 0;
        }

        if (root.getLeft() == null && root.getRight() == null){
            return 1;
        }

        return numberOfLeafNode(root.getLeft()) + numberOfLeafNode(root.getLeft());
    }

    //主方法
    public static void main(String[] args){
        root = build();
        prevOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println("树中节点的个数为:" + numberOfNode(root));
        System.out.println("树中叶子节点的个数为:" + numberOfLeafNode(root));
    }
}
