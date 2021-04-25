import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序查找树
 *
 * https://leetcode-cn.com/problems/increasing-order-search-tree/description/
 *
 * algorithms
 * Easy (72.62%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    52.4K
 * Total Submissions: 70K
 * Testcase Example:  '[5,3,6,2,4,null,8,1,null,null,null,7,9]'
 *
 * 给你一棵二叉搜索树，请你 按中序遍历
 * 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数的取值范围是 [1, 100]
 * 0 
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
    public List<TreeNode> preOrderList;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return root;

        preOrderList = new ArrayList<>();
        
        preOrder(root);

        Collections.sort(preOrderList, (o1, o2)->(o1.val - o2.val));

        root = preOrderList.get(0);
        TreeNode p = root;
        p.left = null;

        for (int i = 1; i < preOrderList.size(); i++) {
            TreeNode node = preOrderList.get(i);
            node.left = null;

            p.right = node;
            p = p.right;
        }

        return root;
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        
        preOrder(root.left);
        preOrderList.add(root);
        preOrder(root.right);
    }
}
// @lc code=end

