import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (62.69%)
 * Likes:    621
 * Dislikes: 0
 * Total Accepted:    143K
 * Total Submissions: 227.4K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10 
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new LinkedList<>();
        
        dfs(nums, path, used, 0);
        
        return ans;
    }

    private void dfs(int[] nums, Deque<Integer> path, boolean[] used, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 &&  !used[i - 1] && nums[i] == nums[i - 1]))
                continue;

            used[i] = true;
            path.add(nums[i]);
            
            dfs(nums, path, used, index + 1);

            path.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

