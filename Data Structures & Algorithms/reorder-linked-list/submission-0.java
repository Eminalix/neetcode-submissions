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
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;

        ListNode head1 = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now the middle pointer
        // we need to reverse the list starting at slow
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode tail = reverse(head2);

        // merge the 2 lists
        while(tail != null) {
            ListNode node1 = head1.next;
            ListNode node2 = tail.next;
            head1.next = tail;
            tail.next = node1;
            head1 = node1;
            tail = node2;
        }
    }
}
