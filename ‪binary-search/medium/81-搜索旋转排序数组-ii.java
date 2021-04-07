/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (37.35%)
 * Likes:    317
 * Dislikes: 0
 * Total Accepted:    62.7K
 * Total Submissions: 166.4K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 ）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ...,
 * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如，
 * [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值
 * target ，则返回 true ，否则返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return false;
    
        return binarySearch(nums, 0, len - 1, target) < 0 ? false : true;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (right < left)
            return -1;
        
        int mid = (left + right) / 2;

        int leftValue = nums[left];
        int rightValue = nums[right];
        int midValue = nums[mid];

        if (leftValue == target)
            return left;
        else if (rightValue == target)
            return right;
        else if (midValue == target)
            return mid;

        if (leftValue == midValue && rightValue == midValue) {
            return binarySearch(nums, left + 1, right - 1, target);
        } else if (leftValue <= midValue) {
            if (target < midValue && target >= leftValue) {
                return binarySearch(nums, left + 1, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right - 1, target);
            }
        } else {
            if (target > midValue && target <= rightValue) {
                return binarySearch(nums, mid + 1, right - 1, target);
            } else {
                return binarySearch(nums, left + 1, mid - 1, target);
            }
        }
    }
}
// @lc code=end

