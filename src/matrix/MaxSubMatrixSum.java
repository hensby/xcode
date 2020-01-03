package matrix;

public class MaxSubMatrixSum {
    MaxSubArray maxSubArray = new MaxSubArray();
    public int[][] preComputeColumnSumMatrix(int[][] m) {
        int columnLength = m[0].length, rowLength = m.length;
        int [][] result = new int[rowLength][columnLength];
        for (int col = 0; col < columnLength; col++) {
            result[0][col] = m[0][col];
            for (int row = 1; row < rowLength; row++) {
                result[row][col] = result[row - 1][col] + m[row][col];
            }
        }
        return result;
    }

    public int getColumnSum(int startRow, int endRow, int nthColumn, int[][] columnSumMatrix) {
        if (startRow == 0) {
            return columnSumMatrix[endRow][nthColumn];
        }
        return columnSumMatrix[endRow][nthColumn] - columnSumMatrix[startRow - 1][nthColumn];
    }

    public int maxSubMatrixSum(int [][] matrix) {
        int [][] rowSumMatrix = preComputeColumnSumMatrix(matrix);
        int m = matrix.length, n = matrix[0].length, res = 0;
        for (int startRow = 0; startRow < m; startRow++) {
            for (int endRow = startRow; endRow < m; endRow++) {
                int[] columnSums = new int[n];
                for (int col = 0; col < n; col++) {
                    columnSums[col] = getColumnSum(startRow, endRow, col, rowSumMatrix);
                }
                int curMax = maxSubArray.maxSubArray(columnSums);
                res = Math.max(curMax, res);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        MaxSubMatrixSum maxSubmatrixSum = new MaxSubMatrixSum();
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] matrix = new int[][] {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        printMatrix.pringMatrix(matrix);
        int [][] res = maxSubmatrixSum.preComputeColumnSumMatrix(matrix);
        printMatrix.pringMatrix(res);
        System.out.println(maxSubmatrixSum.maxSubMatrixSum(matrix));
    }
}

/*
Given an integer matrix, find a sub matrix where the sum of numbers is maximum. Your code should return the max sum.
Example

Given matrix

[
  [1, -2, -4],
  [1, -1, -1],
  [-2, 3,  4],
]

return the max sum 7
 */