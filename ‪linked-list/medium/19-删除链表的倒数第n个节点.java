/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode p = pHead;
        for (int i = 1; i <= n + 1; ++i) 
            p = p.next;

        ListNode q = pHead;
        while (p != null) {
            p = p.next;
            q = q.next;
        }   

        p = q.next;
        q.next = p.next;
        return pHead.next;
    }
}
// @lc code=end

