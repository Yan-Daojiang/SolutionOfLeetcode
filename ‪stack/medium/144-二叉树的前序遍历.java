import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode currNode = root;
        
        while (!stack.isEmpty() || currNode != null) {
            while (currNode != null) {
                ans.add(currNode.val);
                stack.push(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            currNode = currNode.right;
        } // whille

        return ans;
    }
}
// @lc code=end

