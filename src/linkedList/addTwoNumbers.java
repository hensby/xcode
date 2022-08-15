package linkedList;

public class addTwoNumbers {
    public static ListNodeInternal addTwoNumbers(ListNodeInternal l1, ListNodeInternal l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNodeInternal root = null, current = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int currentVal = l1Val + l2Val + carry;
            carry = currentVal / 10;
            if (root == null) {
                root = current = new ListNodeInternal(currentVal % 10);
            } else {
                current.next = new ListNodeInternal(currentVal % 10);
                current = current.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            current = new ListNodeInternal(carry);
        }
        return root;
    }

    public static void main(String[] args) {
        ListNodeInternal l1 = new ListNodeInternal(2), root1 = l1;
        l1.next = new ListNodeInternal(4);
        l1 = l1.next;
        l1.next = new ListNodeInternal(3);
        ListNodeInternal l2 = new ListNodeInternal(5), root2 = l2;
        l2.next = new ListNodeInternal(6);
        l2 = l2.next;
        l2.next = new ListNodeInternal(4);
        addTwoNumbers(root1, root2);
    }
}

class ListNodeInternal {
     int val;
    ListNodeInternal next;
    ListNodeInternal() {}
    ListNodeInternal(int val) { this.val = val; }
    ListNodeInternal(int val, ListNodeInternal next) { this.val = val; this.next = next; }
 }
