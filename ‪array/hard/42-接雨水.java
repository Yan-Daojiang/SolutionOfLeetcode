/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 纵向求解每个位置能够装的水
        int ans = 0;
        if (height == null || height.length == 0)
            return ans;
        
        int[] leftMax = new int[height.length];
        int currLeftMax = leftMax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (currLeftMax < height[i - 1]) {
                currLeftMax = height[i - 1];
            }
            leftMax[i] = currLeftMax;
        }

        int[] rightMax = new int[height.length];
        int currRightMax = rightMax[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (currRightMax < height[i + 1]) {
                currRightMax = height[i + 1];
            }
            rightMax[i] = currRightMax;
        }

        for (int i = 0; i < height.length; i++) {
            if (height[i] < Math.min(leftMax[i], rightMax[i]))
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        

        return ans;
    }
}
// @lc code=end

