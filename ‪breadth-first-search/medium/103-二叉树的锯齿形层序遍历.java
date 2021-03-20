import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (57.06%)
 * Likes:    412
 * Dislikes: 0
 * Total Accepted:    122.4K
 * Total Submissions: 214.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层序遍历如下：
 * 
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();

        List<List<Integer>> ans = new ArrayList<>();

        Deque<TreeNode>[] stack = new Deque[2];
        stack[0] = new LinkedList<>();
        stack[1] = new LinkedList<>();

        int current = 0;
        int next = 1;

        stack[current].add(root);

        List<Integer> list = new ArrayList<>();

        while (!stack[0].isEmpty() || !stack[1].isEmpty()) {
            TreeNode node = stack[current].pop();
            list.add(node.val);

            if (current == 0) {
                if (node.left != null) {
                    stack[next].push(node.left);
                }

                if (node.right != null) {
                    stack[next].push(node.right);
                }
            } else {
                if (node.right != null) {
                    stack[next].push(node.right);
                } 

                if (node.left != null) {
                    stack[next].push(node.left);
                }
            }

            if (stack[current].isEmpty()) {
                ans.add(list);
                list = new ArrayList<Integer>();
                current = 1 - current;
                next = 1 - next;
            }
        }
        
        return ans;
    }
}
// @lc code=end

