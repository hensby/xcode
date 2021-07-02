package merge;

import java.util.PriorityQueue;

public class MergeKsortedLinklist {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (null != node) {
                pq.add(node);
            }
        }
        if (pq.size() == 0) return null;

        ListNode root = new ListNode(-1);
        ListNode cur = pq.poll();
        if (null != cur && null != cur.next) pq.add(cur.next);
        root.next = cur;
        while (pq.size() > 0) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = cur.next;
            if (null != tmp.next) {
                pq.add(tmp.next);
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode cur = new ListNode(4, tail);
        ListNode root = new ListNode(1, cur);

        ListNode tail1 = new ListNode(4);
        ListNode cur1 = new ListNode(3, tail1);
        ListNode root1 = new ListNode(1, cur1);

        ListNode tail2 = new ListNode(6);
        ListNode root2 = new ListNode(2, tail2);

        ListNode[] input = new ListNode[]{root, root1, root2};
        ListNode res = mergeKLists(input);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
//23. Merge k Sorted Lists
//        You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//        Merge all the linked-lists into one sorted linked-list and return it.
//
//
//
//        Example 1:
//
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6
//        Example 2:
//
//        Input: lists = []
//        Output: []
//        Example 3:
//
//        Input: lists = [[]]
//        Output: []
