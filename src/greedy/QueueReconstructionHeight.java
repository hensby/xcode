package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//406
public class QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0]? p1[1] - p2[1] : p2[0] - p1[0]);
        System.out.println(Arrays.deepToString(people));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
            for(int[] i : queue) {
                System.out.print(Arrays.toString(i) + " ");
            }
            System.out.println();
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        QueueReconstructionHeight q = new QueueReconstructionHeight();
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(q.reconstructQueue(people)));
    }
}
