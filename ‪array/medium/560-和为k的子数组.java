/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 *
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.72%)
 * Likes:    980
 * Dislikes: 0
 * Total Accepted:    124.9K
 * Total Submissions: 279.1K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 
 * 示例 1 :
 * 
 * 
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 
 * 
 * 说明 :
 * 
 * 
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preSum = new int[length + 1];

        for (int i = 1; i < nums.length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (preSum[i] - preSum[j] == k) 
                    cnt++;
            }
        }


        return cnt;
    }
}
// @lc code=end

