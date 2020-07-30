package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        System.out.println(Arrays.deepToString(people));
        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
            System.out.println(Arrays.deepToString(output.toArray(new int[n][2])));
        }

        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {7, 0},{4, 4},{7, 1},{5, 0},{6, 1},{5, 2}
        };
        ReconstructQueue r = new ReconstructQueue();
        System.out.println(Arrays.deepToString(r.reconstructQueue(input)));
    }
}
