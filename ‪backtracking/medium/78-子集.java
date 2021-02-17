import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        List<Integer> currSubSet = new ArrayList<>();
        dfs(nums, 0, currSubSet, ans);

        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> currSubSet, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(currSubSet));

        for (int i = index; i < nums.length; i++) {
            currSubSet.add(nums[i]);
            dfs(nums, i + 1, currSubSet, ans);
            currSubSet.remove(currSubSet.size() - 1);
        }
        return;
    }
}
// @lc code=end
