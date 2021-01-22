import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums == null || nums.length == 0)
            return ans;

        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, path, used, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, Deque<Integer> path, boolean[] used, int depth, List<List<Integer>> ans) {
        if (depth == nums.length) {
            ans.add(new ArrayList<Integer> (path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) 
                continue;
                
            used[i] = true;
            path.addLast(nums[i]);

            dfs(nums, path, used, depth + 1, ans);
            
            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

