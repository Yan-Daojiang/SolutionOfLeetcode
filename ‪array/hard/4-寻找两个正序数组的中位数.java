/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 归并两个有序数组
        if (nums1 == null && nums2 == null)
            return 0;
        
        double[] ans = new double[nums1.length + nums2.length];
        int i = 0, j = 0;
        int ansIndex = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) 
                ans[ansIndex++] = nums1[i++];
            else 
                ans[ansIndex++] = nums2[j++];
        }

        if (i >= nums1.length) {
            while (j < nums2.length) 
               ans[ansIndex++] = nums2[j++]; 
        }
        else {
            while (i < nums1.length)
                ans[ansIndex++] = nums1[i++];
        }

        // 返回序列的中位数
        if ((nums1.length + nums2.length) % 2 != 0)
            return ans[(nums1.length + nums2.length) / 2];
        else 
            return  (ans[(nums1.length + nums2.length) / 2] +  ans[(nums1.length + nums2.length) / 2 - 1]) / 2;
    
    }
}
// @lc code=end

