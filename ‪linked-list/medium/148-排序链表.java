/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        return sortedList(head, null);
    }

    private ListNode sortedList(ListNode head, ListNode tail) {
        if (head == null)
            return head;
        
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head, slow = head;

        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;

            if (fast != tail)
               fast = fast.next;
        }

        ListNode mid = slow;

        ListNode l1 = sortedList(head, mid);
        ListNode l2 = sortedList(mid, tail);

        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) 
            p.next = l1;
        else 
            p.next = l2;

        return dummyHead.next;
    }
}
// @lc code=end

