package Amazon_onsite;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LinkNode {
        int key;
        int value;
        LinkNode next;
        LinkNode prev;
    }

    int capacity;
    int size;
    Map<Integer, LinkNode> cache = new HashMap<>();
    LinkNode root;
    LinkNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.root = new LinkNode();
        this.tail = new LinkNode();
        root.next = tail;
        tail.prev = root;
    }

    private void addToFront(LinkNode node) {
        LinkNode nodeAfterRoot = root.next;
        root.next = node;
        nodeAfterRoot.prev = node;
        node.prev = root;
        node.next = nodeAfterRoot;
    }

    private void remove(LinkNode node) {
        LinkNode nodeBefore = node.prev;
        LinkNode nodeAfter = node.next;
        nodeBefore.next = nodeAfter;
        nodeAfter.prev = nodeBefore;
    }

    private void moveToFront(LinkNode node) {
        remove(node);
        addToFront(node);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        LinkNode node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LinkNode node = cache.get(key);
            node.value = value;
//            cache.put(key, node);
            moveToFront(node);
        } else {
            LinkNode node = new LinkNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addToFront(node);
            if (size == capacity) {
                LinkNode nodeBeforeTail = tail.prev;
                remove(nodeBeforeTail);
                cache.remove(nodeBeforeTail.key);
            } else {
                size++;
            }
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
//        146. LRU Cache
//        Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//        The cache is initialized with a positive capacity.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4