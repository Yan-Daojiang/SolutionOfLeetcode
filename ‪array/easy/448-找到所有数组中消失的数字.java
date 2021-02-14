/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] % (nums.length + 1);
            nums[x - 1] += (nums.length + 1);
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] <= nums.length)
                ans.add(i + 1);
        }

        return ans;
    }
}
// @lc code=end

