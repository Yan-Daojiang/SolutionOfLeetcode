/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = null;

        if (m > n)
            return dummy;

        ListNode p = head;
        int i = 1;
        ListNode q = dummy;

        while (p != null) {
            while (i < m) {
                q.next = p;
                p = p.next;
                q = q.next;
                ++i;
            }

           
            ListNode end = p;
            q.next = null;

            while (i <= n) {
                ListNode currNode = p;
                p = p.next;
                
                currNode.next = q.next;
                q.next = currNode;
                ++i;
            }

            end.next = p;
            break;
        }

        return dummy.next;
    }
}
// @lc code=end

