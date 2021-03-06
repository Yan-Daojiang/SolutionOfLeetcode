import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    boolean[][] f;

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0)
            return ans;

        // 动态规划预处理
        f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) 
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
        }
        

        dfs(s, 0, new ArrayList<String>(), ans);

        return ans;
    }

    /**
     * 
     * @param s
     * @param index
     * @param currentSubString
     * @param ans
     */
    private void dfs(String s, int index, List<String> currentSubString, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<String>(currentSubString));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // if (!check(s, index, i))
            //     continue;

            if (!f[index][i])
                continue;

            currentSubString.add(s.substring(index, i + 1));
            dfs(s, i + 1, currentSubString, ans);

            // 回溯
            currentSubString.remove(currentSubString.size() - 1);;
        }
    }

//    /**
//     * 检查串s的字串s[low..high]是否是一个回文串, 是回文串返回true, 否则返回false
//     * @param s
//     * @param low
//     * @param high
//     * @return
//     */
//    private boolean check(String s, int low, int high) {
//        while (low < high) {
//            if (s.charAt(low) != s.charAt(high))
//                return false;
//
//            ++low;
//            --high;
//        }
//        return true;
//    }
}
// @lc code=end

