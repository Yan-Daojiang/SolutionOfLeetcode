import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (49.50%)
 * Likes:    943
 * Dislikes: 0
 * Total Accepted:    140.6K
 * Total Submissions: 284K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len + 1 - k];

        // 构造大顶堆，堆中元素对为<数组中的数， 索引>， 索引用于判断是否在窗口中
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2)->(o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]));

        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[]{nums[i], i});
        }

        ans[0] = maxHeap.peek()[0];

        for (int i = k; i < len; i++) {
            maxHeap.add(new int[]{nums[i], i});
            // 当前的最大不在窗口中就删除
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            ans[i - k + 1] = maxHeap.peek()[0];
        }

        return ans;
    }
}
// @lc code=end

