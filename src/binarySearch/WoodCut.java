package binarySearch;

public class WoodCut {
    public int woodCut1(int[] L, int k) {
        int min = 0, max = 0;
        for (int len : L) {
            max = Math.max(len, max);
        }
        while (min + 1 < max) {
            System.out.println(min + " " + max);
            int mid = min + ((max - min) >>> 1);
            int numberMid = countNum(L, mid);
            if (numberMid >= k) {
                min = mid;
            } else {
                max = mid;
            }
        }
        System.out.println(min + " " + max);
        return min;
    }

    public int countNum(int[] L, int mid) {
        int count = 0;
        for (int len : L) {
            count += len / mid;
        }
        return count;
    }

    public int woodCut2(int[] L, int k) {

        if (L.length == 0 || k <= 0) return -1;
        int left = 0, right = 0;
        for (int l : L) {
            right = Math.max(right, l);
        }
        while (left + 1 < right) {
            int mid = left + ((right - left) >>> 1);
            System.out.println(left + "  " + mid + "   " + right);

            if (countNum1(L, mid) >= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countNum1(int[] L, int length) {
        int count = 0;
        for (int l : L) {
            count += l / length;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        WoodCut woodCut = new WoodCut();
        int[] s = new int[]{232, 124, 456};
        System.out.println(woodCut.woodCut2(s, 7));
        System.out.println(woodCut.woodCut1(s, 7));
    }
}
/**
 * Wood Cut Given n pieces of wood with length L[i] (integer array). Cut
 * them into small pieces to guarantee you could have equal or more than k
 * pieces with the same length. What is the longest length you can get from
 * the n pieces of wood? Given L & k, return the maximum length of the small
 * pieces. Priorities: 1. Have to get calculatedK >= givenK 2. Meanwhile,
 * want to maximize the small piece. One thing not clear: do we have to use
 * the given small piece? If we have to, we need to concern about the
 * shortest wood piece. See commentted-out part In this problem, however, we
 * can abandon the small pieces, as long as the max_small_pieces can allow
 * calculatedK >= givenK. Use binary search on the largest item: 1. if
 * calculatedK < givenK: end = mid; 2. If calculated >= givenK, move start =
 * mid as much as possible, which gives maximized small piece.
 * <p>
 * start = 0, end = 5, wrong 4
 * L [5], k = 1
 */