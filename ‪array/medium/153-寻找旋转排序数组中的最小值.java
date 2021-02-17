/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
    
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < ans)
                ans = nums[i];
        }
        return ans;
    }
}
// @lc code=end

