/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode q = head, p = head.next;
        while (p != null && q != null) {
            if (p == q)
                return true;
            
            p = p.next;
            if (p == null)
                return false;
                
            p = p.next;
            q = q.next;
        }   
        return false;
    }
}
// @lc code=end

