package linkedList;

public class IntersectionTwoLinkedListsLCCI {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int sizeA = 1, sizeB = 1;
        while(pA != null || pB != null) {
            if(pA != null) {
                sizeA++;
                pA = pA.next;
            }
            if(pB != null) {
                sizeB++;
                pB = pB.next;
            }
        }
        pA = headA;
        pB = headB;
        int diffSize = Math.abs(sizeB - sizeA);
        boolean flag = sizeA > sizeB? true: false;
        for(int i = 0; i < diffSize; i++) {
            if(flag) pA = pA.next;
            else pB = pB.next;
        }
        while(pA != null && pB != null) {
            if(pB == pA) return pA;
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //思路：双指针法。一个指针指向A链表，一个指向B链表。如果相遇则返回，否则没有交点。

        //如果存在相交结点，那么pA和pB一定会相遇。
        if(headA == null || headB == null)  return null;

        ListNode pA = headA,pB = headB;

        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    public static void main(String[] args) {
        IntersectionTwoLinkedListsLCCI i = new IntersectionTwoLinkedListsLCCI();

    }
}
//面试 02。07
