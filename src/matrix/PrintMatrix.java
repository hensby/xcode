package matrix;

import java.util.List;

public class PrintMatrix {
    public void printMatrix(int[][] matrix) {
        for (int[] re : matrix) {
            for (int j = 0; j < re.length; j++) {
                System.out.printf("%d ", re[j]);
            }
            System.out.println(" ");
        }
    }

    public void printMatrix(List<int[]> matrix) {
        for (int[] re : matrix) {
            for (int j = 0; j < re.length; j++) {
                System.out.printf("%d ", re[j]);
            }
            System.out.println(" ");
        }
    }

}
