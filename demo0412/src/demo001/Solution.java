package demo001;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

class Solution {
    //保存最大路径和
    static int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //最大路径和初始化为最小 Integer 值
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }

    //递归求解最大路径和
    private static int helper(TreeNode root){
        //若当前节点为空
        if (root == null){
            return 0;
        }
        //求当前节点左子树的最大路径和
        int left = Math.max(0, helper(root.left));
        //求当前节点有子树的最大路径和
        int right = Math.max(0, helper(root.right));
        //保存当前的最大路径和(最大路径和为当前 result 与 当前节点与其左右子树的路径和 相比之后较大的值
        result = Math.max(result, left + right + root.val);
        //返回当前节点的左右子树中较大的值与当前节点值的和,作为上一节点的最大路径和
        return Math.max(left, right) + root.val;
    }
}