import java.util.Deque;
import java.util.LinkedList;

import javax.swing.plaf.multi.MultiInternalFrameUI;

import org.graalvm.compiler.lir.LIRInstruction.Temp;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        Deque<Integer> stackMulti = new LinkedList<>();
        Deque<String> stackAns = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stackAns.push(ans.toString());
                ans = new StringBuilder();

                stackMulti.push(multi);
                multi = 0;
            } else if (ch == ']') {
                StringBuilder tmp = new StringBuilder();
                int currMulti = stackMulti.pop();
                for (int i = 0; i < currMulti; i++) 
                    tmp.append(ans);
                
                ans = new StringBuilder(stackAns.pop() + tmp);
            } else if (ch >= '0' && ch <= '9') {
                multi = multi * 10 + (ch - '0');
            } else {
                ans.append(ch);
            }
        }
    
        return ans.toString();
    }
}
// @lc code=end

