import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        
        Arrays.sort(nums);
        // 第一次做的时候，排序之后回溯中使用HashSet的特性进行去重
        // 这么做虽然简单， 但是效率不高。主要是因为要搜索所有的子集，同时加入结果集合时要检查是否重复
        // Set<List<Integer>> ans = new HashSet<>();

        // 增加剪枝操作, 直接返回List结果
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currSubSetDup = new ArrayList<>();
        dfs(nums, 0, currSubSetDup, ans);

        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> currSubSetDup, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(currSubSetDup));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            currSubSetDup.add(nums[i]);
            dfs(nums, i + 1, currSubSetDup, ans);
            currSubSetDup.remove(currSubSetDup.size() - 1);
        }

        return;
    }
}
// @lc code=end

