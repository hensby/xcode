package linkedList;

import java.util.Stack;

/*
 * 1 -> 2 -> 3 -> 4
        |
        5 -> 6 -> 7
             |
             8


          =

1 -> 2 -> 5 -> 6 -> 8 -> 7 -> 3 -> 4
 */

public class FlattenLinked {
    public static class ListNode {
        public int value;
        public ListNode next;
        public ListNode down;

        public ListNode(int value) {
            this.value = value;
            next = null;
            down = null;
        }
    }


    public static void main(String[] args) {
        ListNode head = createList();
        flattenLinked(head);
        print(head);
        System.out.println();
        System.out.println("--------");
        head = createList();
        flattenLinked2(head);
        print(head);

        System.out.println();
        System.out.println("--------");
        // 1 -> 2
        //      |
        //      3
        //      |
        //      4 -> 5
        head = createList2();
        flattenLinked(head);
        print(head);
        System.out.println();
        System.out.println("--------");
        head = createList2();
        flattenLinked2(head);
        print(head);
        // System.out.println(Arrays.toString(result));
    }

    private static ListNode createList2() {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.down = new ListNode(3);
        head.next.down.down = new ListNode(4);
        head.next.down.down.next = new ListNode(5);
        return head;
    }

    private static ListNode createList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.down = new ListNode(5);
        head.next.down.next = new ListNode(6);
        head.next.down.next.next = new ListNode(7);
        head.next.down.next.down = new ListNode(8);
        return head;
    }

    private static void print(ListNode head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.print(head.value + "=>");
            head = head.next;
        }

    }

    public static void flattenLinked(ListNode head) {
        // use recursion
        // edge case
        if (head == null) {
            return;
        }
        flatten(head);
    }

    // return tail
    private static ListNode flatten(ListNode cur) {
        if (cur.down != null) {
            ListNode down = cur.down;
            ListNode next = cur.next;
            ListNode tail = flatten(cur.down);
            cur.down = null;
            cur.next = down;
            tail.next = next;
        }

        if (cur.next == null) {
            // tail
            return cur;
        }
        return flatten(cur.next);
    }

    public static void flattenLinked2(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> s = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            if (cur.down != null) {
                ListNode down = cur.down;
                ListNode next = cur.next;
                if (next != null) {
                    s.add(next);
                }
                cur.down = null;
                cur.next = down;
            }

            if (cur.next == null && !s.isEmpty()) {
                // tail
                cur.next = s.pop();
            }

            cur = cur.next;
        }
    }


}
