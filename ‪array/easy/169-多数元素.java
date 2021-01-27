/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority)
                ++count;
            else 
                --count;
            
            if (count < 0) {
                majority = nums[i];
                count = 0;
            }
        }

        return majority;
    }
}
// @lc code=end

