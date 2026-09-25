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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode prev = head;
        ListNode urm = head.next.next;

        if(urm == null) return false;

        while(urm != null && urm.next != null) {
            if(urm.next == prev) return true;
            urm = urm.next.next;
            prev = prev.next;
        }

        return false;
    }
}
