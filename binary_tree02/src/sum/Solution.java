package sum;

import java.util.*;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}


public class Solution {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    private static ArrayList<ArrayList<Integer>> result = null;
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        dfs(new ArrayList<>(), root, sum, 0);

        return result;
    }

    public static void dfs(ArrayList<Integer> preList, TreeNode root, int sum, int curSum) {
        curSum += root.val;
        ArrayList<Integer> list = new ArrayList<>(preList);
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == curSum) {
                result.add(list);
            }
            return;
        }

        if (root.left != null) {
            dfs(list, root.left, sum, curSum);
        }

        if (root.right != null) {
            dfs(list, root.right, sum, curSum);
        }
    }
}