/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode dummy = new ListNode(-1, head);
        // 将链表从中间部分断开
        ListNode fast = head, slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) 
                fast = fast.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        // 后面一部分原地翻转
        head2 = reverse(head2);

        // 逐个比较
        ListNode p = head, q = head2;
        while (p != null && q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        } 

        return true;
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

