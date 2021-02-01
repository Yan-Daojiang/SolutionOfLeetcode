/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        return sortLists(lists, 0, lists.length - 1);
    }

    private ListNode sortLists(ListNode[] lists, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return lists[left];
        
        int mid = (left + right) >> 1;
        return merge(sortLists(lists, left, mid), sortLists(lists, mid + 1, right));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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