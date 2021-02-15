/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0)
            return ans;

        int length = nums.length;
        
        int left = 0, right = 0;
        while (left < length && right < length) {
            if (nums[left] == 1) {
                right = left;
                while (right < length && nums[right] == 1) {
                        ++right;
                }
                int curMaxOne = right - left;
                ans = Math.max(ans, curMaxOne);
                left = right;
            } else {
                ++left;
            }
            
        }

        return ans;
    }
}
// @lc code=end

