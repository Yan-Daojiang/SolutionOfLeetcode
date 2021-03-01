import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (45.90%)
 * Likes:    699
 * Dislikes: 0
 * Total Accepted:    189.1K
 * Total Submissions: 411.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 用sum来表示和，用diffAbs表示和target差的绝对值，表示相近的程度
        int sum = 0;
        int currBestCloseSum = 10000;  

        Arrays.sort(nums);
        int len = nums.length;
        for (int i =0; i < len; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;
                
                if (Math.abs(sum - target) < Math.abs(currBestCloseSum - target))
                    currBestCloseSum = sum;
                
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k])
                        --k0;

                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j])
                        ++j0;
                    
                    j = j0;
                }
            } 
        }

        return currBestCloseSum;
    }
}
// @lc code=end

