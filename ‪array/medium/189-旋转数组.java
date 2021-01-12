/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        // nums[start..end]进行原地逆置
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end] ;
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
// @lc code=end

