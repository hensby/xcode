import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    public node[] hashValue;
    /** Initialize your data structure here. */
    public MyHashMap() {
        int numberBucket = 2067;
        hashValue = new node[numberBucket];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashFunction(key);
        System.out.println(hashValue[hash]);
        node tmp = new node(key, value);
        if (hashValue[hash] == null) {
            hashValue[hash] = tmp;
        }
        else {
            node cur = hashValue[hash];
            cur.next = tmp;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashFunction(key);
        if (hashValue[hash] == null) return -1;
        else {
            node cur = hashValue[hash];
            while(cur!= null) {
                if(cur.key == key) return cur.value;
                else cur = cur.next;
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (get(key) == -1) return;
        else {
            int hash = hashFunction(key);
            node cur = hashValue[hash];

            while(cur.next != null) {
                node prev = cur; cur = cur.next;
                if(cur.key == key) {
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }
        }
        return;
    }

    private int hashFunction(int key) {
        return key % 2067;
    }

    class node{
        int key, value;
        node prev, next;

        node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
//class MyHashMap {
//
//    class Node{
//        int key, value;
//        Node prev, next;
//
//        Node (int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    private int length = 100;
//    private Node[] data = new Node[length];
//
//    /** Initialize your data structure here. */
//    public MyHashMap() {
//
//    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        int index = key % length;
//        Node curr = data[index];
//        if (curr == null) {
//            Node node = new Node(key, value);
//            data[index] = node;
//            return;
//        }
//        while(true) {
//            if (curr.key == key) {
//                curr.value = value;
//                return;
//            }
//            if(curr.next == null) {
//                Node node = new Node(key, value);
//                node.prev = curr;
//                curr.next = node;
//                return;
//            } else {
//                curr = curr.next;
//            }
//        }
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        int index = key % length;
//        Node curr = data[index];
//        while(curr != null) {
//            if (curr.key == key) {
//                return curr.value;
//            }
//            curr = curr.next;
//        }
//        return -1;
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        int index = key % length;
//        Node curr = data[index];
//        if (curr != null && curr.key == key) {
//            Node next = curr.next;
//            if (next != null) {
//                next.prev = null;
//            }
//            data[index] = next;
//            return;
//        }
//        while(curr != null) {
//            if (curr.key == key) {
//                Node next = curr.next;
//                Node prev = curr.prev;
//                if (next != null) {
//                    next.prev = prev;
//                }
//                if (prev != null) {
//                    prev.next = next;
//                }
//                return;
//            }
//            curr = curr.next;
//        }
//    }


    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,100);
        System.out.println(obj.hashValue[1]);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        obj.remove(1);
    }

}

