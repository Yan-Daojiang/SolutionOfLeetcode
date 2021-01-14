/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        
        ListNode p = head;

        for (int i = 1; i <= k; i++) {
            if (p == null)
                return p;

            p = p.next;
        }
        
        ListNode q = head;
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        
        return q;
    }
}