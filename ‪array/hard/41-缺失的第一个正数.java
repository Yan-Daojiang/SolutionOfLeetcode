import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (40.52%)
 * Likes:    981
 * Dislikes: 0
 * Total Accepted:    113.9K
 * Total Submissions: 280.1K
 * Testcase Example:  '[1,2,0]'
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 
 * 
 * 
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,2,0]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * -2^31 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        
        // 先将数组排序在进行搜索
        Arrays.sort(nums);
        int len = clear(nums);
        int num = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != num)
                return num;
            else 
                ++num;
        }
        return num;
    }

    /**
     * 清除排序数组中小于等于0的数和重复的数
     * @param nums
     * @param start
     * @param end
     * @return 处理后数组的有效长度
     */
    private int clear(int[] nums) {
        int len = nums.length;
        int left = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                continue;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[left] = nums[i];
                ++left;
            }
        }

        return left;
    }
}
// @lc code=end

