package matrix;

public class PrintMatrix {
    public void pringMatrix(int[][] matrix) {
        for (int[] re : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ", re[j]);
            }
            System.out.println(" ");
        }
    }
}
