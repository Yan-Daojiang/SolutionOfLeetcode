/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode p = head;
        ListNode q = head;
        while(p.next != null && q.next != null) {
            p = p.next;
            q = q.next ;
            if ( p.next != null)
                p =  p.next;
        }
        ListNode head2 = q.next;
        q.next = null;
        
        head2 = reverseList(head2);

        p = head;
        q = head2;
        
        while (q != null) {
            ListNode next = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = next;
        }
        
    }

    private ListNode reverseList(ListNode head) {
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

