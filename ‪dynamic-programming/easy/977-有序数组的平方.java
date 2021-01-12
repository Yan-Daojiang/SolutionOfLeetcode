/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
// @lc code=end

