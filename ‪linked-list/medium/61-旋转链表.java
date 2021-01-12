/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        int listLength = getListLength(head);
        k = k % listLength;
        // 构造头节点
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode p = head;

        // 先将链表断开，在按照尾插法插入到第一个链表后面
        for (int i = 1; i <= listLength - k - 1; i++)
            p = p.next;

        // 将链表断开
        ListNode q = p.next;
        p.next = null;
        // q进行尾插法
        ListNode temp = pHead;
        while (q != null) {
            p = q.next;
            q.next = temp.next;
            temp.next = q;
            q = p; 
            temp = temp.next;
        }
        return pHead.next;
    }
    
    private int getListLength(ListNode head) {
        // 获取链表长度
        int length = 0;
        for (ListNode p = head; p != null; p = p.next)
            ++length;
        return length;
    }
}
// @lc code=end

