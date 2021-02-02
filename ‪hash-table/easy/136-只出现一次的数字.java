/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // map中key为数字， value为出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else 
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        for (int i = 0; i < nums.length; i++) 
            if (map.get(nums[i]) == 1)
                 return nums[i];
                 
        return -1;
    }
}
// @lc code=end

