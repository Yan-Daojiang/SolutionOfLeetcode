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
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode node = dummy;

        ListNode p = head;
        ListNode q = head.next;

        while (p!= null && q != null) {
            if (p.val != q.val) {
                node.next = p;
                node = node.next;
                p = q;
                q = q.next;
            } else {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }

                node.next = q;

                if (q == null || q.next == null)
                    break;
                
                p = q;
                q = p.next;
            }
        }

        return dummy.next;
    }
}
// @lc code=end

