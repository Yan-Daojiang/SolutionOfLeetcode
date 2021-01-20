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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();
            
        List<List<Integer>> ans = new ArrayList<>();
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
                ans.add(list);
                currentLevel = nextLevel;
                nextLevel = 0;
                list = new ArrayList<>();
            }
        } // while

        return ans;
    }
}