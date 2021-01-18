/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        if (k <= 0)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode start = pre.next;

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end == null)
                    return dummy.next;
                end = end.next;
            }
            if (end == null)
                return dummy.next;
                   
            // 将链先断开
            ListNode next = end.next;
            end.next = null;

            pre.next = reverse(start);
            
            // 将链再接上
            start.next = next;

            pre = start;
            end = start;
            start = next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode p, q;
        // 头插法
        ListNode phead = new ListNode(-1);
        phead.next = null;

        p = head;
        while (p != null) {
            q = p.next;
            p.next = phead.next;
            phead.next = p;
            p = q; 
        }
        return phead.next;
    }
}
// @lc code=end

