public class WoodCut {
    public int woodCut1(int[] L, int k) {
        int min = 0, max = 0;
        for (int len: L) {
            max = Math.max(len, max);
        }
        while (min+1 < max) {
            System.out.println(max);
            int mid = min + ((max - min) >>> 1);
            int numberMid = countNum(L, mid );
            if (numberMid >= k) {
                min = mid;
            }else {
                max = mid;
            }
        }
        return min;
    }

    public int countNum(int[] L, int mid) {
        int count = 0;
        for (int len: L) {
            count += len / mid;
        }
        return count;
    }


    public int woodCut(int[] L, int k) {
        int end = 0;

        for (int len : L) {
            end = Math.max(end, len);
        }

        if (numWood(end, L) >= k) {
            return end;
        }

        // trying to cut with length 1 - max
        int start = 0;
        while (start + 1 < end) {
            int mid = start + ((end - start) >>> 1);  //binary search
            int numMid = numWood(mid, L);
            if (numMid >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int numWood(int length, int[] L) {
        int count = 0;
        for (int len : L) {
            count += len / length;
        }
        return count;
    }

    public static void main(String[] args) {
        WoodCut woodCut = new WoodCut();
        int[] s = new int[]{232, 124, 456};
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