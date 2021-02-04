/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int baseLine = partition(nums, left, right);
            quickSort(nums, left, baseLine - 1);
            quickSort(nums, baseLine + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int tmp = nums[left];

        if (left > right)
            return -1;

        while (left < right) {
            while (left < right && nums[right] >= tmp)
                right--;
            nums[left] = nums[right];

            while (left < right && nums[left] < tmp)
                left++;
            nums[right] = nums[left];
        }
        
        nums[left] = tmp;
        return left;
    }
}
// @lc code=end

