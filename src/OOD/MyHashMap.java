package OOD;

public class MyHashMap {

    private Node[] hashMapBucket;

    public MyHashMap() {
        hashMapBucket = new Node[500];
    }

    public void put(int key, int value) {
        int hashCode = key % 500;
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        } else {
            Node head = hashMapBucket[hashCode];
            Node newNode = new Node(key, value);
            if (head == null) hashMapBucket[hashCode] = newNode;
            else {
                hashMapBucket[hashCode] = newNode;
                newNode.next = head;
            }
        }
        return;
    }

    public int get(int key) {
        int hashCode = key % 500;
        Node head = hashMapBucket[hashCode];
        if (head == null) return -1;
        while (head != null) {
            if (head.key == key) {
                return head.value;
            } else {
                head = head.next;
            }
        }
        return -1;
    }

    public Node getNode(int key) {
        int hashCode = key % 500;
        Node head = hashMapBucket[hashCode];
        if (head == null) return null;
        while (head != null) {
            if (head.key == key) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    public void remove(int key) {
        int hashCode = key % 500;
        Node head = hashMapBucket[hashCode];
        if (head == null) return;
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    hashMapBucket[hashCode] = head.next;
                } else {
                    Node next = head.next;
                    prev.next = next;
                }
                break;
            } else {
                prev = head;
                head = head.next;
            }
        }
    }

    public class Node {
        Integer value;
        Integer key;
        Node next;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

//class OOD.MyHashMap {
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
//    public OOD.MyHashMap() {
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
        obj.put(1, 100);
        obj.put(2, 1200);

        System.out.println(obj.get(1));
        int param_2 = obj.get(1);
        System.out.println(param_2);
        System.out.println(obj.get(2));
        obj.remove(1);
        System.out.println(obj.get(1));
    }

}

