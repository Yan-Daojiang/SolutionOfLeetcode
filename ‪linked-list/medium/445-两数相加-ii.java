/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        return reverseList(ReverseAddTwo(l1, l2));
    }
    
    public ListNode ReverseAddTwo(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, cur = head;
        int flag = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (flag > 0) 
            cur.next = new ListNode(flag);
        return head.next;
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

