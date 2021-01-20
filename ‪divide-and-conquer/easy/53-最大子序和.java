/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        return maxSubSum(nums, 0, nums.length - 1);
    }

    private int maxSubSum(int[] nums, int left, int right) {
        int ans = 0;
        if (left == right)
            return nums[left];
        
        int mid = (left + right) / 2;
        int maxLeftSum = maxSubSum(nums, left, mid);
        int maxRightSum = maxSubSum(nums, mid + 1, right);
        
        int maxLeftBorderSum = nums[mid];
        int leftBorderSum = 0;
        int maxRightBorderSum = nums[mid];
        int rightBorderSum = 0;
        
        for (int i = mid; i >= left; i--) {
            leftBorderSum += nums[i];
            maxLeftBorderSum = Math.max(leftBorderSum, maxLeftBorderSum);
        }
        
        for (int j = mid; j <= right; j++) {
            rightBorderSum += nums[j];
            maxRightBorderSum = Math.max(rightBorderSum, maxRightBorderSum); 
        }

        int maxMidSum = maxLeftBorderSum + maxRightBorderSum - nums[mid];
        
        ans = getMaxOfThree(maxLeftSum, maxMidSum, maxRightSum);

        return ans;
    }

    private int getMaxOfThree(int a, int b, int c) {
        int ans;
        if (a > b)
            ans = a;
        else 
            ans = b;
        
        if (ans < c)
            return c;
        
        return ans;
    }
}
// @lc code=end

