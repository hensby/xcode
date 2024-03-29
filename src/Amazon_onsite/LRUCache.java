package Amazon_onsite;

import java.util.HashMap;
import java.util.Map;

public class LRUCache { // O(1) O(C)

    class LinkedNode {
        int val;
        int key;
        LinkedNode next;
        LinkedNode prev;
        public LinkedNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
        public LinkedNode() {}
    }

    int capacity, size;
    LinkedNode root, tail;
    Map<Integer, LinkedNode> cacheMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.size = 0;
        this.root = new LinkedNode();
        this.tail = new LinkedNode();
        root.next = tail;
        tail.prev = root;
    }

    public void addFirst(LinkedNode node) {
        LinkedNode tmpNext = root.next;
        root.next = node;
        node.prev = root;
        node.next = tmpNext;
        tmpNext.prev = node;
    }

    public LinkedNode removeTail() {
        LinkedNode tmpTail = tail.prev;
        remove(tmpTail);
        return tmpTail;
    }

    public void remove(LinkedNode node) {
        LinkedNode prevNode = node.prev;
        LinkedNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void moveToHead(LinkedNode node) {
        remove(node);
        addFirst(node);
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        LinkedNode cur = cacheMap.get(key);
        moveToHead(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            LinkedNode curNode = cacheMap.get(key);
            curNode.val = value;
            cacheMap.put(key, curNode);
            moveToHead(curNode);
            return;
        }
        LinkedNode curNode = new LinkedNode(key, value);
        size++;
        if (size > capacity) {
            LinkedNode CurTail = removeTail();
            cacheMap.remove(CurTail.key);
            size--;
        }
        addFirst(curNode);
        cacheMap.put(key, curNode);
        return;
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
//        OOD.LRUCache cache = new OOD.LRUCache( 2 /* capacity */ );
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