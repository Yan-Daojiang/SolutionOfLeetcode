/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode p = head, q = head.next;
        ListNode node = dummyNode;
        while (q != null) {
            if (p.val != q.val) {
                node = node.next;
                p = p.next;
                q = q.next;
            } else {
                while (q != null && p.val == q.val)
                    q = q.next;
                
                node.next = q;
                if (q == null || q.next == null)
                    break;

                p = q;
                q = q.next;
            }
        } 

        return dummyNode.next;
    }
}
// @lc code=end

