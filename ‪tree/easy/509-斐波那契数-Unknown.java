/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        ArrayList <Integer> dp = new ArrayList(n);
        dp.add(0,0);
        dp.add(1, 1);
        dp.add(2, 1);
        for (int i = 3; i <= n; i++)
            dp.add(dp.get(i-1) + dp.get(i - 2));
        return dp.get(n);
    }
}
// @lc code=end

