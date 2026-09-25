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
        Map<Node, Node> map = new HashMap<>();

        if(head == null) {
            Node newHead = null;
            return newHead;
        }

        Node curr = head;
        Node newHead = new Node(head.val);
        map.put(head, newHead);

        while(curr != null) {
            map.putIfAbsent(curr, new Node(curr.val));
            Node newCurr = map.get(curr);

            if(curr.next != null) {
                map.putIfAbsent(curr.next, new Node(curr.next.val));
                Node newNext = map.get(curr.next);
                newCurr.next = newNext;
            }
            
            if(curr.random != null) {
                map.putIfAbsent(curr.random, new Node(curr.random.val));
                Node newRandom = map.get(curr.random);
                newCurr.random = newRandom;
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