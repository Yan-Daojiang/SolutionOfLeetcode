import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.05%)
 * Likes:    893
 * Dislikes: 0
 * Total Accepted:    157.8K
 * Total Submissions: 228K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;

        int len = preorder.length;

        map = new HashMap<>();
        for (int i = 0; i < len; i++) 
            map.put(inorder[i], i);

        return build(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight)
            return null;
        // 先序遍历的第一个节点就是当前子树的根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历序列中找到根节点所在索引的位置
        int rootIndexInInOrder = map.get(rootVal);


        // 确定左右子树的节点的数目
        int leftNum = rootIndexInInOrder - inLeft;
        int rightNum = inRight - rootIndexInInOrder;
        
        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftNum, inLeft, rootIndexInInOrder - 1);
        root.right = build(preorder, inorder, preLeft + leftNum + 1, preRight, rootIndexInInOrder + 1, rootIndexInInOrder + rightNum);

        return root;
    }
}
// @lc code=end

