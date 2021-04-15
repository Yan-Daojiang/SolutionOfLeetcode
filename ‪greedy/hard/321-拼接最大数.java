/*
 * @lc app=leetcode.cn id=321 lang=java
 *
 * [321] 拼接最大数
 *
 * https://leetcode-cn.com/problems/create-maximum-number/description/
 *
 * algorithms
 * Hard (42.73%)
 * Likes:    374
 * Dislikes: 0
 * Total Accepted:    23.6K
 * Total Submissions: 55.1K
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n)
 * 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * 
 * 示例 1:
 * 
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 
 * 示例 2:
 * 
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 
 * 示例 3:
 * 
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * 
 */

// @lc code=start
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 + len2 < k) {
            return new int[0];
        }

        int[] ans = new int[k];

        int start = Math.max(0, k - len2);
        int end = Math.min(len1, k);

        for (int i = start; i <= end; i++) {
            int[] subSequence1 = getMaxSubsequence(nums1, i);
            int[] subSequence2 = getMaxSubsequence(nums2, k - i);

            int[] curMaxSubSequence = merge(subSequence1, subSequence2);

            if (compare(curMaxSubSequence, 0, ans, 0) > 0) {
                System.arraycopy(curMaxSubSequence, 0, ans, 0, k);
            }
        }

        return ans;
    }

    public int[] getMaxSubsequence(int nums[], int k) {
        int[] stack = new int[k];  // 维护一个单调不减栈(受到元素数量和k的限制（返回的栈中一定要保证有k个元素）这里不一定严格满足单调栈的定义)
        int top = -1;

        int len = nums.length;
        int remain = len - k; // 确保栈中元素数目为k

        for (int i = 0; i < len; i++) {
            int num = nums[i];

            while (top >= 0 && stack[top] < num && remain > 0) {
                --top;
                --remain;
            } 

            if (top < k - 1) {
                stack[++top] = num;
            } else {
                --remain;
            }
        }

        return stack;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0) 
            return nums2;
        if (len2 == 0) 
            return nums1;

        int[] mergerArray = new int[len1 + len2];

        int index1 = 0, index2 = 0;
        for (int i = 0; i < len1 + len2; i++) {
            if (compare(nums1, index1, nums2, index2) > 0) {
                mergerArray[i] = nums1[index1++];
            } else {
                mergerArray[i] = nums2[index2++];
            }
        }

        return mergerArray;
    }

    public int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        while (index1 < len1 && index2 < len2) {
            int diff = nums1[index1] - nums2[index2];

            if (diff != 0) {
                return diff;
            }

            ++index1;
            ++index2;
        }

        return (len1 - index1) - (len2 - index2);
    }
}
// @lc code=end

