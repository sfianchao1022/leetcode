package leetcode.DFS;

public class Solution {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else if (root.left != null && root.right != null) {
            if (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val)) {
                return true;
            } else {
                return false;
            }
        } else if (root.left == null && root.right != null) {
            return hasPathSum(root.right, targetSum - root.val);
        } else if (root.left != null && root.right == null) {
            return hasPathSum(root.left, targetSum - root.val);
        } else {
            return false;
        }

    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}




