package matrix;


import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;//4,3
        PriorityQueue<MatrixTuple> q = new PriorityQueue<>();
        int x = 0, y = 0;
        for (; y < n; y++) {
            q.offer(new MatrixTuple(x, y, matrix[x][y]));
        }

        for (int i = 0; i < k - 1; i++) {
            MatrixTuple t = q.poll();
            x = t.x;
            y = t.y;
            if (x == m - 1) {
                continue;
            }
            q.offer(new MatrixTuple(x + 1, y, matrix[x + 1][y]));
        }
        return q.poll().val;
    }

    class MatrixTuple implements Comparable<MatrixTuple> {
        int x, y, val;

        public MatrixTuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(MatrixTuple other) {
            return Integer.compare(this.val, other.val);
        }

//        @Override
//        public String toString() {
//            return "MatrixTuple [x=" + x + ", y=" + y + ", val=" + val + "]";
//        }
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int l = matrix[0][0]; // smallest element
        int r = matrix[m - 1][m - 1]; // biggest element
        while (l < r) {
            int mid = l + ((r - l) >>> 1);
            int count = 0; // number of elements no bigger than mid

            for (int i = 0; i < m; i++) {
                int[] row = matrix[i];
                if (mid < row[0]) {
                    break;
                }

                int index = Arrays.binarySearch(row, mid);
                if (index < 0) {
                    index = -(index + 1);
                    count += index;
                } else {
                    // in case of duplicates, we need to move to most right
                    while (index < m - 1 && row[index + 1] == row[index]) {
                        index++;
                    }
                    count += index + 1;
                }
            }

            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15},
                {16, 17, 18}
        };
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(matrix, 12));
    }
}
/*
 Kth Smallest Element in a Sorted Matrix
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 Reference: Find K Pairs with Smallest Sums
 Note that visited is needed because you may add duplicates into the queue.
 */