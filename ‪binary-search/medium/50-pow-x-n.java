/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if ((x - 0) == 0)
            return 0;
        int absOfn = n;
        if (n < 0)
            absOfn = -n;
        
        double result = getPow(x, absOfn);
        
        if (n < 0)
            result = 1.0 / result;
        
        return result;
    }

    private double getPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        
        double result = getPow(x, n >>> 1);
        result *= result;
        
        // 一个数与2的n次方求余，可用数与运算(2^n - 1)
        if ((n & 1) == 1)
            result *= x;

        return result;
    }

    // private double getPow(double x, int absOfn) {
    //     double result = 1.0;
    //     for (int i = 1; i <= absOfn; ++i)
    //         result *= x;
        
    //     return result;
    // }
}
// @lc code=end

