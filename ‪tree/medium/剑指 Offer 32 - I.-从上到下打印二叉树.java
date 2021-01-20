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
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return new int[0];
        
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();

            list.add(currentNode.val);
            if (currentNode.left != null)
                queue.add(currentNode.left);
            
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}