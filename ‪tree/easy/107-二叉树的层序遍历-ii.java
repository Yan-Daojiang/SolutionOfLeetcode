import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList();
            
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int currentLevel = 1;
        int nextLevel = 0;

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            currentLevel--;

            list.add(currentNode.val);

            if (currentNode.left != null) {
                nextLevel++;
                queue.add(currentNode.left);
            }
            
            if (currentNode.right != null) {
                nextLevel++;
                queue.add(currentNode.right);
            }

            if (currentLevel == 0) {
                ans.addFirst(list);
                // ans.add(list);
                currentLevel = nextLevel;
                nextLevel = 0;
                list = new ArrayList<>();
            }
        } // while

        return ans;
    }
}
// @lc code=end