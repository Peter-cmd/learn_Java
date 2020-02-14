package job14.demo0003;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class Solution0214 {
    public List<Integer> rightSideView(TreeNode root){
        //处理二叉树为空的情况
        if (root == null){
            return new ArrayList<>();
        }
        int size;
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();  //创建一个队列存储节点
        ArrayList<Integer> list = new ArrayList<>();  //创建链表存储右视的节点
        queue.add(root);  //将根节点插入队列
        while (!queue.isEmpty()){  //若队列不为空
            size = queue.size();  //获取每一层的节点个数
            for (int i = 0; i < size; i++){  //遍历每一层的每一个元素
                node = queue.poll();
                if (i == size - 1){  //若访问每一层的最后一个节点
                    list.add(node.val);
                }

                if (node.left != null){  //若当前节点的左节点不为空
                    queue.add(node.left);
                }

                if (node.right != null){  //若当前节点的右节点不为空
                    queue.add(node.right);
                }

            }

        }
        return list;
    }
}
