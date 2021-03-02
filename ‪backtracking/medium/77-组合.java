import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (76.42%)
 * Likes:    507
 * Dislikes: 0
 * Total Accepted:    136.7K
 * Total Submissions: 178.6K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        if (k < 0 || n < k)
            return ans;

        dfs(n, k, 1, path, ans);

        return ans;
    }

    private void dfs(int n, int k, int start, ArrayList<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

