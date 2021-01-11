/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode q = pHead, p = pHead.next;
        while (p != null) {
            if (p.val == val) { 
                // 删除当前节点后，p向前一步，q保持不变
                q.next = p.next;
                p = p.next;
            }
            else {
                q = p;
                p = p.next;
            }
        }
        return pHead.next;
    }
}
// @lc code=end

