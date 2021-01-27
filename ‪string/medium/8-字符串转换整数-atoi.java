import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        DFA dfa = new DFA();
        for (int i = 0; i < s.length(); i++) {
            dfa.get(s.charAt(i));
        }

        return (int)(dfa.flaged * dfa.ans);
    }
}

class DFA {
    public int flaged = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char ch) {
        state = table.get(state)[getCol(ch)];
        if (state.equals("in_number")) {
            ans = ans * 10 + (ch - '0');
            ans = (flaged == 1) ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
        } else if (state.equals("signed")) {
            flaged = (ch == '+') ? 1 : -1;
        }
    }

    private int getCol(char ch) {
        if (ch == ' ')
            return 0;
        else if (ch == '+' || ch == '-')
            return 1;
        else if (Character.isDigit(ch))
            return 2;
        else 
            return 3;
    }
   
    
}
// @lc code=end

