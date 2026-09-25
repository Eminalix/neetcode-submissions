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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        ListNode i = l1;
        ListNode j = l2;

        while(i != null && j != null) {
            int val = i.val + j.val;
            if(carry != 0) val++;
            carry = val / 10;
            ListNode node = new ListNode(val % 10, null);
            current.next = node;
            current = current.next;
            i = i.next;
            j = j.next;
        }

        while(i != null) {
            int val = i.val;
            if(carry != 0) val++;
            carry = val / 10;
            ListNode node = new ListNode(val % 10, null);
            current.next = node;
            current = current.next;
            i = i.next;
        }

        while(j != null) {
            int val = j.val;
            if(carry != 0) val++;
            carry = val / 10;
            ListNode node = new ListNode(val % 10, null);
            current.next = node;
            current = current.next;
            j = j.next;
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry, null);
            current.next = node;
        }

        return dummyHead.next;
    }
}