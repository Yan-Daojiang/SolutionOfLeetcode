import java.lang.invoke.ClassSpecializer.Factory;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        Deque<Character> ansSeq = new LinkedList<>();
        
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int flag = 0;

        while (indexA >= 0 || indexB >= 0) {
            char cha = (indexA >= 0 ? a.charAt(indexA) : '0');
            char chb = (indexB >= 0 ? b.charAt(indexB) : '0');

            int sum = (cha - '0') + (chb - '0') + flag;

            if (sum == 0) {
                ansSeq.add('0');
                flag = 0;
            } else if (sum == 1) {
                ansSeq.add('1');
                flag = 0;
            } else if (sum == 2) {
                ansSeq.add('0');
                flag = 1;
            } else {
                ansSeq.add('1');
                flag = 1;
            }
            
            --indexA;
            --indexB;
        }

        if (flag == 1)
            ansSeq.add('1');
        
        StringBuilder ans = new StringBuilder();

        while (!ansSeq.isEmpty()) 
            ans.append(ansSeq.removeLast());

        return ans.toString();
    }
}
// @lc code=end

