package build;

import java.util.List;
import java.util.ArrayList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 将前序遍历的数组转换成列表
        List<Integer> preorderList = arrayToList(preorder);
        // 将中序遍历的数组转换成列表
        List<Integer> inorderList = arrayToList(inorder);

        // 若前序遍历列表为空, 则返回
        if (preorderList.isEmpty()) {
            return null;
        }

        TreeNode root = buildTreeHelper(preorderList, inorderList);
        return root;
    }

    // 根据前序和中序遍历结果, 构建二叉树
    private static TreeNode buildTreeHelper(List<Integer> preorderList, List<Integer> inorderList) {

        if (preorderList.isEmpty()) {
            return null;
        }

        // 获取前序列表的第一个元素, 作为当前的 root 的值
        int rootVal = preorderList.get(0);
        // 在中序列表中找与当前 root 的值相等的元素下标
        int rootIndex = inorderList.indexOf(rootVal);
        int leftTreeSize = rootIndex;

        // 在前序遍历列表中确定当前 root 左子树的范围
        List<Integer> leftSubTreePreorderList = preorderList.subList(1, leftTreeSize + 1);
        // 在中序遍历列表中确定当前 root 左子树的范围
        List<Integer> leftSubTreeInorderList = inorderList.subList(0, leftTreeSize);
        // 构建当前 root 的左子树
        TreeNode left = buildTreeHelper(leftSubTreePreorderList, leftSubTreeInorderList);

        // 在前序遍历列表中确定当前 root 右子树的范围
        List<Integer> rightSubTreePreorderList = preorderList.subList(1 + leftTreeSize, preorderList.size());
        // 在中序遍历列表中确定当前 root 右子树的范围
        List<Integer> rightSubTreeInorderList = inorderList.subList(rootIndex + 1, inorderList.size());
        // 构建当前 root 的右子树
        TreeNode right = buildTreeHelper(rightSubTreePreorderList, rightSubTreeInorderList);

        // 记录当前 root 的 left 和 right
        TreeNode root = new TreeNode(rootVal);
        root.left = left;
        root.right = right;
        // 返回当前 root
        return root;
    }

    // 将数组转化成列表
    private static List arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }
}
