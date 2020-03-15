import java.util.HashMap;
public class LRUCache {
    class DLinkNode{
        int key;
        int val;
        DLinkNode prev;
        DLinkNode next;
    }

    public void addNode (DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove (DLinkNode node) {
        DLinkNode nodePrev = node.prev;
        DLinkNode nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    public void moveToHead (DLinkNode node) {
        remove(node);
        addNode(node);
    }

    public DLinkNode removeTail () {
        DLinkNode node = tail.prev;
        remove(node);
        return node;
    }

    int size = 0, capacity = 0;
    private DLinkNode head, tail;
    HashMap<Integer, DLinkNode> cache = new HashMap<Integer, DLinkNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode();
            newNode.val = value;
            newNode.key = key;
            addNode(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }
}
