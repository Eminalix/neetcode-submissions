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
        ListNode head = l1;

        while(l1.next != null && l2.next != null) {
            l1.val += l2.val + carry;
            carry = l1.val / 10;
            l1.val %= 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode prev = l1;
        l1.val += l2.val + carry;
        carry = l1.val / 10;
        l1.val %= 10;

        if(l1.next != null || l2.next != null) {
            while(l1.next != null) {
                l1 = l1.next;
                l1.val += carry;
                carry = l1.val / 10;
                l1.val %= 10;
            }

            while(l2.next != null) {
                l2 = l2.next;
                l1.next = new ListNode(0, null);
                l1 = l1.next;

                l1.val += l2.val + carry;
                carry = l1.val / 10;
                l1.val %= 10;
            }
        }

        if(carry == 1) {
            l1.next = new ListNode(carry, null);
        }

        return head;
    }
}
