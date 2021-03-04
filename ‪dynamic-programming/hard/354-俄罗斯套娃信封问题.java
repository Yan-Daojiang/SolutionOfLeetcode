import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 *
 * https://leetcode-cn.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (38.89%)
 * Likes:    346
 * Dislikes: 0
 * Total Accepted:    31K
 * Total Submissions: 77.6K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h)
 * 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 说明:
 * 不允许旋转信封。
 * 
 * 示例:
 * 
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int ans = 1;
        
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2)
            return 0;


        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            // 先按照长递增排序（当长相同时按照宽递减排序）
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) {
                    return e2[1] - e1[1];
                } else {
                    return e1[0] - e2[0];
                }
            }
        });

        int[] dp = new int[envelopes.length];
        dp[0] = 1;

        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
// @lc code=end

