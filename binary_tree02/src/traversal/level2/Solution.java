package traversal.level2;

import java.util.*;

 class TreeNode {
     public int val = 0;
     public TreeNode left = null;
     public TreeNode right = null;
     public TreeNode(int val){
         this.val = val;
     }
 }

public class Solution {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        String s = "";
        s.toLowerCase();
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        ArrayList<Integer> item = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nLast = null;
        boolean flag = false;
        queue.offer(root);
        // 若 queue 中还有元素
        while (!queue.isEmpty()){
            TreeNode cur = null;
            // 若 flag 为 true, 从右向左打印
            if (flag){
                // 即从队尾取出第一个元素
                cur = queue.pollLast();
                // 依次将当前节点的右节点和左节点加入队首, 提供给下一层从左向右打印使用
                if (cur.right != null){
                    queue.addFirst(cur.right);
                    // 下一层插入的第一个节点, 即为下一层的结束节点
                    nLast = nLast == null ?  cur.right : nLast;
                }
                if (cur.left != null){
                    queue.addFirst(cur.left);
                    nLast = nLast == null ? cur.left : nLast;
                }

            }else{  // 若 flag 为 false, 从左向右打印
                // 即从队首取出第一个元素
                cur = queue.pollFirst();
                // 依次将当前节点的左节点和右节点加入队尾, 提供给下一层从右向左打印使用
                if (cur.left != null){
                    queue.addLast(cur.left);
                    // 下一层插入的第一个节点, 即为下一层的结束节点
                    nLast = nLast == null ? cur.left : nLast;
                }
                if (cur.right != null){
                    queue.addLast(cur.right);
                    nLast = nLast == null ? cur.right : nLast;
                }
            }
            // 将当前的节点值加入 item
            item.add(cur.val);
            // 若 cur 等于 last, 表示一层打印完毕
            if (cur == last){
                // 将当前
                result.add(new ArrayList<>(item));
                // 清空当前的 item
                item.clear();
                // 标记下一层的结束节点
                last = nLast;
                // 下一层的结束节点置空
                nLast = null;
                // 更新打印顺序标志
                flag = !flag;
            }
        }
        return result;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }
}