package matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImageOverlap {

    static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Point other = (Point) o;

            return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

//        @Override
//        public String toString() {
//            return "Point<" + x + "," + y + ">";
//        }
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int m = A.length, ans = 0;
        int[][] count = new int[2 * m - 1][2 * m - 1];
        for (int xi = 0; xi < m; xi++) {
            for (int yi = 0; yi < m; yi++) {
                if (A[xi][yi] == 0) continue;
                for (int xj = 0; xj < m; xj++) {
                    for (int yj = 0; yj < m; yj++) {
                        if (B[xj][yj] == 0) continue;
                        int deltaX = xi - xj + m - 1;
                        int deltaY = yi - yj + m - 1;
                        count[deltaX][deltaY] += 1;
                        ans = Math.max(count[deltaX][deltaY], ans);
                    }
                }
            }

        }
        return ans;
    }

    public int largestOverlap2(int[][] A, int[][] B) {
        int n = A.length;
        // Key is using delta via Point, value is number of overlap
        Map<Point, Integer> count = new HashMap<>();
        int ans = 0;
        for (int xi = 0; xi < n; ++xi) {
            for (int yi = 0; yi < n; ++yi) {
                if (A[xi][yi] != 1) {
                    continue;
                }
                for (int xj = 0; xj < n; ++xj) {
                    for (int yj = 0; yj < n; ++yj) {
                        if (B[xj][yj] != 1) {
                            continue;
                        }
                        int deltaX = xi - xj;
                        int deltaY = yi - yj;
                        Point p = new Point(deltaX, deltaY);
                        int diff = count.getOrDefault(p, 0) + 1; //if doesn't have p, return defaultValue.
                        count.put(p, diff);
                        ans = Math.max(diff, ans);
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] B = new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };
        ImageOverlap imageOverlap = new ImageOverlap();
        System.out.println(imageOverlap.largestOverlap2(A, B));
    }
}
/*
 Image Overlap
 Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

 We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

 (Note also that a translation does not include any kind of rotation.)

 What is the largest possible overlap?

 Example 1:

 Input: A = [[1,1,0],
 [0,1,0],
 [0,1,0]]
 B = [[0,0,0],
 [0,1,1],
 [0,0,1]]
 Output: 3
 Explanation: We slide A to right by 1 unit and down by 1 unit.
 Notes:

 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 0 <= A[i][j], B[i][j] <= 1
 */
