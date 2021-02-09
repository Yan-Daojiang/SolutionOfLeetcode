import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
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
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        dfs(root, new StringBuilder(), ans);

        return ans;
    }

    private void dfs(TreeNode root, StringBuilder currentString, List<String> ans) {
        if (root == null)
            return ;
        
        currentString.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            ans.add(currentString.toString());
            return;
        } else {
            // 因为要取所有路径， 因此涉及到回溯
            dfs(root.left, currentString.append("->"), ans);
            currentString.delete(currentString.lastIndexOf("->"), currentString.length());

            dfs(root.right, currentString.append("->"), ans);
            currentString.delete(currentString.lastIndexOf("->"), currentString.length());
        }
    }
}
// @lc code=end

