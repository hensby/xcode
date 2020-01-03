package matrix;

import java.util.HashMap;
import java.util.Map;

public class SubmatrixSum {
    public int[][] submatrixSum(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            throw new IllegalArgumentException();
        }

        int n = matrix[0].length;

        int[][] res = new int[2][2];
        int[][] sums = preComputeColumnSumMatrix(matrix);
        for (int startRow = 0; startRow < m; startRow++) {
            for (int endRow = startRow; endRow < m; endRow++) {
                int sum = 0;
                // key is seen sum, value is its index
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int columnSum = getColumnSum(startRow, endRow, i, sums);
                    sum += columnSum;
                    if (columnSum == 0) { // Current column is 0
                        res[0] = new int[] { startRow, i };
                        res[1] = new int[] { endRow, i };
                        return res;
                    }

                    if (sum == 0) { // sum of elements from (startRow,0) to
                        // (endRow, i) is 0
                        res[0] = new int[] { startRow, 0 };
                        res[1] = new int[] { endRow, i };
                        return res;
                    }

                    Integer index = map.get(sum);
                    if (index != null) { // sum is already present in hash map
                        res[0] = new int[] { startRow, index + 1 };
                        res[1] = new int[] { endRow, i };
                        return res;
                    }

                    map.put(sum, i);
                }
            }
        }

        // We reach here only when there is no subMatrix with 0 sum
        return null;
    }

    // return a helper matrix whose (i, j) element is the sum of (0, j) to (i, j) on jth column
    // O(n^2)
    private int[][] preComputeColumnSumMatrix(int[][] m)
    {
        int columnLength = m[0].length, rowLength = m.length;

        int[][] result = new int[rowLength][columnLength];
        for (int col = 0; col < columnLength; col++)
        {
            result[0][col] =  m[0][col];
            for(int row = 1; row < rowLength; row++) {
                result[row][col] = result[row-1][col] + m[row][col];
            }
        }

        return result;
    }

    // return the sum from "startRow" to "endRow" on column "nthColumn"\
    // constant time
    private int getColumnSum(int startRow, int endRow, int nthColumn,
                             int[][] columnSumMatrix) {
        if (startRow == 0) {
            return columnSumMatrix[endRow][nthColumn];
        }
        return columnSumMatrix[endRow][nthColumn]
                - columnSumMatrix[startRow - 1][nthColumn];
    }


//    public int[][] submatrixSum (int[][] matrix) {
//        MaxSubMatrixSum maxSubMatrixSum = new MaxSubMatrixSum();
//        int m = matrix.length;
//        if (m == 0) {
//            throw new IllegalArgumentException();
//        }
//        int n = matrix[0].length;
//        int[][] res = new int[2][2];
//        int[][] sums = maxSubMatrixSum.preComputeColumnSumMatrix(matrix);
//
//        for (int startRow = 0; startRow < m; startRow++) {
//            for (int endRow = startRow; endRow < m; endRow++){
//                Map<Integer,Integer> map = new HashMap<>();
//                int sum = 0;
//                for (int i = 0; i < n; i++) {
//                    int columnSum = maxSubMatrixSum.getColumnSum(startRow, endRow, i, sums);
//                    sum +=columnSum;
//                    if (columnSum == 0) {
//                        res[0] = new int[]{startRow, i};
//                        res[1] = new int[]{endRow, i};
//                        return res;
//                    }
//                    if (sum == 0) {
//                        res[0] = new int[]{startRow, 0};
//                        res[1] = new int[]{endRow, i};
//                        return res;
//                    }
//                    Integer index = map.get(sum);
//                    if (index != null) {
//                        res[0] = new int[]{startRow, index - 1};
//                        res[1] = new int[]{endRow, i};
//                        return res;
//                    }
//                    map.put(sum, i);
//                }
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        SubmatrixSum submatrixSum = new SubmatrixSum();
        int [][] matrix = new int[][] {
                {1 ,5 ,7},
                {3 ,7 ,-8},
                {4 ,-8 ,9}
        };
        PrintMatrix printMatrix = new PrintMatrix();
        printMatrix.pringMatrix(matrix);
        int[][] res = new int[2][2];
        res = submatrixSum.submatrixSum(matrix);
        printMatrix.pringMatrix(res);
    }

}
