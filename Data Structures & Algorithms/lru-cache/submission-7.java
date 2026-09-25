class Node {
    int val;
    int key;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
        this.key = -1;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity = 0;
    private int size = 0;
    Node dummyHead, dummyTail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        dummyHead = new Node(-1);
        dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        // insert it at beginning to be marked as MRU
        Node temp = map.get(key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.next = dummyHead.next;
        dummyHead.next.prev = temp;
        temp.prev = dummyHead;
        dummyHead.next = temp;

        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        Node temp;

        if(!map.containsKey(key)) {
            size++;
            temp = new Node(value);
            temp.key = key;
            map.put(key, temp);
        }
        else {
            temp = map.get(key);
            temp.val = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        dummyHead.next.prev = temp;
        temp.next = dummyHead.next;
        dummyHead.next = temp;
        temp.prev = dummyHead;
        
        // need to remove from list
        if(size > capacity) {
            temp = dummyTail.prev;
            temp.prev.next = dummyTail;
            dummyTail.prev = temp.prev;
            map.remove(temp.key);
            size--;
        }
    }
}
/*
    have a doubly linked list for O(1) removal and insertion
    have 2 dummy sentinels for head and tail
    to avoid null checks
    have a hashmap that maps key to node
    when i add a node, add at front
    when i delete, i delete at the end
    if the list size > capacity i delete last node
    once i get a node, i delete it and re insert it at the beginning
    since it was most recently used and should not be deleted
*/