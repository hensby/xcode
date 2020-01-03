package matrix;

public class NumberMatrix {
    private int[][] sums;

    public NumberMatrix(int[][] matrix){
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;

        this.sums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.sums[i + 1][j + 1] = matrix[i][j] + this.sums[i][j + 1] + this.sums[i + 1][j] - this.sums[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.sums[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (this.sums == null) return 0;
        return this.sums[row2 + 1][col2 + 1] - this.sums[row1][col2 + 1] - this.sums[row2 + 1][col1] + this.sums[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5},
        };
        NumberMatrix numberMatrix = new NumberMatrix(matrix);
        System.out.println(numberMatrix.sumRegion(2,1,4,3));
    }
}
