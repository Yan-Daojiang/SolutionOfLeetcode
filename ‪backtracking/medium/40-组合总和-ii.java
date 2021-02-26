/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (64.14%)
 * Likes:    502
 * Dislikes: 0
 * Total Accepted:    133.7K
 * Total Submissions: 208.8K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, combine, 0, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> combine, int begin, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;

            int temp = sum + candidates[i];
            if (temp <= target) {
                combine.add(candidates[i]);
                dfs(candidates, target, combine, i + 1, temp);
                combine.remove(combine.size() - 1);
            } else {
                break;
            }
        }
    }
}

// @lc code=end

