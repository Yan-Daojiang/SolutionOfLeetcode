/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    /**
     * 1..n为一个有序序列，因此我们以i作为根，那么1..i - 1可以
     * 构成二叉搜索树的左子树，i + 1.. n构成二叉搜索树的右子树
     * G(n)表示整数n对应组成的二叉搜索树的个数
     * F(i, n)表示以i为根，长度为n的二叉搜索树的个数
     * 其中G(n)就是我们需要求解的问题，而G(n)与F(i, n)满足
     * G(n) = sum(F(i, n)) (i = 1 ..n) ............(1)
     * 其中G(0) = 1, G(1) = 1;
     * F(i, n) = G(i - 1) * G(n - i)  .............(2)
     * 将(1),(2)结合可知
     * G(n) = sum(G(i - 1)(n - i))   (i = 1..n)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
// @lc code=end

