/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (hashTable.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = hashTable.get(target - nums[i]);
            }
            hashTable.put(nums[i], i);
        } // for
        return ans;
    }
}
// @lc code=end

