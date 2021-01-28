/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return ;
        
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) 
            --i;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) 
                --j;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        i = i + 1;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            ++i;
            --j;
        }
    }
}
// @lc code=end

