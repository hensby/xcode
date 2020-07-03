package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import matrix.PrintMatrix;
// 498
public class DiagonalTraverse498 {
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;
            System.out.println(r + " " + c);
            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    int m, n;
    public int[] findDiagonalOrder1(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        this.m = matrix[0].length;
        this.n = matrix.length;
        int cur = 0;
        int[] res = new int[m * n];
        List<Integer> middleList = new ArrayList<>();

        for(int i = 0; i < m + n - 1; i++) {
            int col = i < m? i: m - 1;
            int row = i < m? 0: i - m + 1;

            middleList.clear();

            while(isValid(col, row)) {
                middleList.add(matrix[row][col]);
                col--;
                row++;
            }
            if(i % 2 == 0) {
                Collections.reverse(middleList);
            }
            for (int j = 0; j < middleList.size(); j++) {
                res[cur++] = middleList.get(j);
            }
        }
        return res;
    }

    public boolean isValid(int col ,int row) {
        return row < n && row >= 0 && col < m && col >= 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        DiagonalTraverse498 diagonal = new DiagonalTraverse498();
//        PrintMatrix printMatrix = new PrintMatrix();
        PrintMatrix.printMatrix(matrix);
        System.out.println(Arrays.toString(diagonal.findDiagonalOrder1(matrix)));
    }
}

