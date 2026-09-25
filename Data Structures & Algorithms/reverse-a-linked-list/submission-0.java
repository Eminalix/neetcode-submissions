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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head; // head.next is the next el and .next asserts the connection 
        // say head is 2 and then the list is 2 3
        // then head.next.next means the connection from 3
        // and head is 2 so from 2->3 to 3->2
        head.next = null; // delete 2->3 connection

        return node;
    }
}
