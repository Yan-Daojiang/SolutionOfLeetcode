/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);
        
        int i = 0, j =0, k = 0;
        while (i < copy.length && j < nums2.length)
            nums1[k++] = (copy[i] <= nums2[j]) ? copy[i++] : nums2[j++];

        while (i < copy.length)
            nums1[k++] = copy[i++];
        
        while (j < nums2.length)
            nums1[k++] = nums2[j++];
    }
}
// @lc code=end

