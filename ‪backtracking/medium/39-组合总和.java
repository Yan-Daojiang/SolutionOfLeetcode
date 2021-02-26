import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (71.98%)
 * Likes:    1177
 * Dislikes: 0
 * Total Accepted:    211.1K
 * Total Submissions: 292.9K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1：
 * 
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, combine, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> combine, int index) {
        if (index == candidates.length)
            return;
        
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        dfs(candidates, target, combine, index + 1);

        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], combine, index);
            combine.remove(combine.size() - 1);
        }

    }
}
// @lc code=end

