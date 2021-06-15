package Amazon_oa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AmazonFreshDeliveries {

    public static int[][] closestKLocations(int[][] allLocations, int k) {
        // set capacity to k+1 to avoid resizing of pq array under-the-hood
        PriorityQueue<int[]> pq = new PriorityQueue<>(k + 1, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                int x1 = a1[0];
                int y1 = a1[1];
                int x2 = a2[0];
                int y2 = a2[1];
                int distance1 = x1 * x1 + y1 * y1;
                int distance2 = x2 * x2 + y2 * y2;

                // tie breaker
                if (distance1 == distance2) return x2 - x1;

                return distance2 - distance1;
            }
        });

        for (int[] location : allLocations) {
            pq.add(location);

            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        pq.toArray(result);

        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{
                {1, 2},
                {1, -1},
                {3, 4}
        };

        int[][] result = closestKLocations(test1, 2);

        for (int[] each_elt : result) {
            System.out.println(String.format("[%d,%d]", each_elt[0], each_elt[1]));
        }
    }
}


//    Given allLocations list of co-ordinates (x,y) you have to find the X - closest locations from truck's location which is (0,0). Distance is calculated using formula (x^2 + y^2).
//        If the there is tie then choose the co-ordinate with least x value.
//        Sample Input :
//        allLocations : [ [1, 2] , [1, -1], [3, 4] ]
//        numOfDeliveries : 2
//        Sample Output :
//        [ [1, -1], [1 , 2] ]
//        Output list can be in any order.
//        This question was basically K closest points to the origin (0,0) with added tie condition.
