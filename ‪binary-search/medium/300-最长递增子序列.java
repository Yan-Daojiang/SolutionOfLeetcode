/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /**
     * 贪心算法 + 二分查找
     * 维护数据d[i]表示子序列长度为i的最长上升子序列的末尾元素的最小值，
     * 可以证明d[i]是一个单调增数组
     * 设当前已经求出的最长上升子序列的长度为maxLength (maxLength初始化为1),遍历数组nums[i]
     * 如果 nums[i] > d[maxLength]， 那么 d[++maxLength] = nums[i]
     * 否则，在数组d中二分查找，找到第一个比nums[i]小的d[k],更新d[++k] = nums[i]
     * @param nums
     * @return maxLength
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 2)
            return nums.length;

        int maxLength = 1;
        int[] d = new int[nums.length + 1];
        d[maxLength] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > d[maxLength]) {
                d[++maxLength] = nums[i];
            } else {
                int left = 1, right = maxLength;
                int pos = 0;

                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } //while
                
                d[pos + 1] = nums[i];
            }
        }

        return maxLength;
    }
}
// @lc code=end

