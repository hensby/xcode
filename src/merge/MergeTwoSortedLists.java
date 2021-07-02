package merge;

public class MergeTwoSortedLists {

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(5);
        ListNode cur = new ListNode(4, tail);
        ListNode root = new ListNode(1, cur);

        ListNode tail1 = new ListNode(4);
        ListNode cur1 = new ListNode(3, tail1);
        ListNode root1 = new ListNode(1, cur1);

        ListNode res = mergeTwoLists(root, root1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
