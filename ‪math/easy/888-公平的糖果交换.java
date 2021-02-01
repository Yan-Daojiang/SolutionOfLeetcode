import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果交换
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        if (A == null || B == null)
            return ans;
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++)
            sumA += A[i];
        for (int j = 0; j < B.length; j++)
            sumB += B[j];

        int average = (sumA + sumB) / 2;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < B.length; j++)
            hashMap.put(B[j], j);
            
        for (int i = 0; i < A.length; i++) {
            if (hashMap.containsKey(A[i] + average - sumA)) {
                ans[0] = A[i];
                ans[1] = A[i] + average - sumA;
                break;
            }
        }

        return ans;
    }
}
// @lc code=end

