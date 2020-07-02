package matrix;

import java.util.List;

public class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        for (int[] re : matrix) {
            for (int j = 0; j < re.length; j++) {
                System.out.printf("%d ", re[j]);
            }
            System.out.println(" ");
        }
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> re : matrix) {
            for (int j = 0; j < re.size(); j++) {
                System.out.printf("%d ", re.get(j));
            }
            System.out.println(" ");
        }
    }

}
