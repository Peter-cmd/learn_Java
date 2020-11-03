package traversal.level1;

import java.util.*;
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}
public class LevelOrder {
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        // 保存每一次的结果
        ArrayList<Integer> item = new ArrayList<>();
        // 保存下一层节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);
        TreeNode last = root;
        TreeNode nLast = null;
        // 若队列不为空
        while (!queue.isEmpty()){
            // 获取队首元素
            TreeNode cur = queue.poll();
            // 队首元素加入 item
            item.add(cur.val);
            // 若当前节点的左节点不为空
            if (cur.left != null){
                queue.offer(cur.left);
                // 更新下一层的结束节点
                nLast = cur.left;
            }
            // 若当前节点的有节点不为空
            if (cur.right != null){
                queue.offer(cur.right);
                // 更新下一层的结束节点
                nLast = cur.right;
            }

            // 若 last 等于 cur,表示一层遍历结束
            if (last == cur){
                // 将当前层中的节点加入最终结果
                result.add(new ArrayList<>(item));
                // 清除当前层的节点
                item.clear();
                last = nLast;
            }
        }

        return result;
    }
}

