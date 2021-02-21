/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int i = 0, j = 0;
        int len = nums.length;
        while(i < len && j < len) {
            if (nums[j] != 0) 
                nums[i++] = nums[j++];
            else 
                ++j;
        }

        for (j = i; j < len; j++)
            nums[j] = 0;
        
        return;
    }
}
// @lc code=end

