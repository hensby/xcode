package Amazon_onsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

    int m, n;

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        this.m = matrix[0].length;
        this.n = matrix.length;
        int cur = 0;
        int[] res = new int[m * n];
        List<Integer> middleList = new ArrayList<>();

        for (int i = 0; i < m + n - 1; i++) {
            int col = i < m ? i : m - 1;
            int row = i < m ? 0 : i - m + 1;

            middleList.clear();

            while (isValid(col, row)) {
                middleList.add(matrix[row][col]);
                col--;
                row++;
            }
            if (i % 2 == 0) {
                Collections.reverse(middleList);
            }
            for (int j = 0; j < middleList.size(); j++) {
                res[cur++] = middleList.get(j);
            }
        }
        return res;
    }

    public boolean isValid(int col, int row) {
        return row < n && row >= 0 && col < m && col >= 0;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        DiagonalTraverse dst = new DiagonalTraverse();
        System.out.println(Arrays.toString(dst.findDiagonalOrder(mat)));
    }

}
//      时间复杂度：O(N⋅M)，数组有 NN 行 MM 列。对于所有奇数对角线上的元素，需要两次处理，迭代和翻转。为了节省空间，需要遍历新对角线之前清除中间使用的空间，该操作需要 O(K)O(K) 的复杂度度，其中 KK 是数组长度。因此至少处理两次数组中的元素，渐进复杂度为 O(N \cdot M)O(N⋅M)。
//      空间复杂度：O(min(N, M))，额外空间用于存储每条对角线的中间数组，该数组长度为 NN 和 MM 的最小值。注意：对角线延伸到索引超出范围结束。
//498. Diagonal Traverse
//        Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
//
//        Example 1:
//
//        Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
//        Output: [1,2,4,7,5,3,6,8,9]
//        Example 2:
//
//        Input: mat = [[1,2],[3,4]]
//        Output: [1,2,3,4]
//
//
//        Constraints:
//
//        m == mat.length
//        n == mat[i].length
//        1 <= m, n <= 104
//        1 <= m * n <= 104
//        -105 <= mat[i][j] <= 105