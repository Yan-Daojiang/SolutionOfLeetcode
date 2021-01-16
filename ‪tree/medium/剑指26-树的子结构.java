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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val)
                result = isSubStructureCore(A, B);
            if (!result)
                result = isSubStructure(A.left, B);
            if (!result)
                result = isSubStructure(A.right, B);
        }
        return result;      
    }

    private boolean isSubStructureCore(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        
        if (A == null)
            return false;

        if (A.val != B.val)
            return false;
        
        return isSubStructureCore(A.left, B.left) && isSubStructureCore(A.right, B.right);
    }
}