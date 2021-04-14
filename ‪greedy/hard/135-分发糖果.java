/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 *
 * https://leetcode-cn.com/problems/candy/description/
 *
 * algorithms
 * Hard (48.11%)
 * Likes:    529
 * Dislikes: 0
 * Total Accepted:    72.2K
 * Total Submissions: 150.1K
 * Testcase Example:  '[1,0,2]'
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 
 * 
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 
 * 
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * ⁠    第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        
        if (ratings == null || len == 0)
            return 0;

        int[] nums = new int[len];

        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 1;
            }
        }

        int ans = 0;
        int right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                ++right;
            } else {
                right = 1;
            }


            ans += Math.max(right, nums[i]);
        }

        return ans;
    }
}
// @lc code=end

