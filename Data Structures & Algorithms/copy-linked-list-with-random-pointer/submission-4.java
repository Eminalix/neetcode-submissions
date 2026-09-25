/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            Node newHead = null;
            return newHead;
        }

        // create copies for each element which u store after the original
        Node curr = head;

        while(curr != null) {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }

        // assign the connection for randoms
        curr = head;

        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // split the list
        curr = head;
        Node newHead = curr.next;

        while(curr != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }

            curr = curr.next;
        }

        return newHead;
    }
}
/*
    i need to have a hashmap to remember
    if for a specific node i already have it 
    in my new list
    if i have it i just connect the node to that other node
    else i need to create a new node and put it in the hashmap
*/