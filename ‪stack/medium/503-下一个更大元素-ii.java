import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 *
 * https://leetcode-cn.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (59.01%)
 * Likes:    334
 * Dislikes: 0
 * Total Accepted:    57.2K
 * Total Submissions: 93.9K
 * Testcase Example:  '[1,2,1]'
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x
 * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 
 * 注意: 输入数组的长度不会超过 10000。
 * 
 */

/**
 * class Solution {
 *    public int[] nextGreaterElements(int[] nums) {
 *        if (nums == null || nums.length == 0)
 *            return new int[0];
 *
 *        int len = nums.length;
 *        int[] ans = new int[len];
 *        Arrays.fill(ans, -1);
 *
 *        for (int i = 0; i < len; i++) {
 *            int j = (i + 1) % len;
 *            while (true) {
 *                if (j != i && nums[j] > nums[i]) {
 *                    ans[i] = nums[j];
 *                    break;
 *                } else if (j == i){
 *                    break;
 *                }
 *                j = (j + 1) % len;
 *            }
 *        }
 *
 *        return ans;
 *    }
 *}
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * len - 1; i++) {
            // 单调栈中存储的是下标
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }

        return ans;
    }
}
// @lc code=end

