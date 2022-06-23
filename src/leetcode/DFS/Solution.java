package leetcode.DFS;

public class Solution {

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

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {

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

    /**
     * 200. Number of Islands
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    sum += 1;
                    callDFS(grid, i, j);
                }
            }
        }

        return sum;
    }

    private static void callDFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        } else {
            grid[i][j] = '0';
            callDFS(grid, i + 1, j);
            callDFS(grid, i - 1, j);
            callDFS(grid, i, j + 1);
            callDFS(grid, i, j - 1);
        }
    }


}




