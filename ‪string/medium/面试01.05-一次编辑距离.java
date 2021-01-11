/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [����01.05] һ�α༭����
 */

// @lc code=start
class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null)
            return true;
        
        // �����ַ����ĳ������ʱ��������ж�
        if (first.length() == second.length()) {
            int diff = 0;
            for (int i = 0; i < first.length(); ++i) {
                if (first.charAt(i) != second.charAt(i))
                    ++diff;

                if (diff >= 2)
                    return false;
            }
            return true;
        } // if

        // �����ַ����ĳ������1ʱ�����������λ�ó���ָ�����2��
        else if (Math.abs(first.length() - second.length()) == 1) {
            int i = 0, j = 0;
            int diff = 0;
            while (i < first.length() && j < second.length()) {
                if (first.charAt(i) != second.charAt(j)) {
                    ++diff;
                    if (diff >= 2)
                        return false;
                    if (first.length() > second.length())
                        ++i;
                    else 
                        ++j;
                }
                else if (first.charAt(i) == second.charAt(j)) {
                    ++i; 
                    ++j;
                }
            } // while
            return true;
        } 
        return false;
    }
}
// @lc code=end

