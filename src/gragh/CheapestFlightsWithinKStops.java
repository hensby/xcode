package gragh;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> adjacency = new ArrayList<List<int[]>>();
        for(int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<int[]>());
        }
        // Map<int[], Integer> flightPrice = new HashMap<>();
        for(int[] flight: flights) {
            adjacency.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        // System.out.println(adjacency.get(1).get(0)[0] + " " + adjacency.get(1).get(0)[1]);
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        int round = 0;
        queue.add(src);
        // boolean[] visited = new boolean[n];
        while(!queue.isEmpty() && round <= K) {
            // System.out.println(11111);
            int size = queue.size();
            // int cur = queue.poll();
            // visited[cur] = true;
            // System.out.println(cur);
            List<int[]> tmpDistances = new ArrayList<int[]>();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // visited[cur] = true;
                // System.out.println(cur);
                for (int[] tmp: adjacency.get(cur)){
                    // if(!visited[tmp[0]]) {
                    queue.add(tmp[0]);
                    // System.out.println(tmp[0] + " " + tmp[1]);
                    // System.out.println(Arrays.toString(distance));
                    tmpDistances.add(new int[]{tmp[0], Math.min(distance[cur] + tmp[1], distance[tmp[0]])});
                    // }
                }
            }
            for(int[] tmpDistance: tmpDistances) {
                distance[tmpDistance[0]] = Math.min(tmpDistance[1], distance[tmpDistance[0]]) ;
            }
            round++;
        }
        // System.out.println(distance[dst]);
        return distance[dst] == Integer.MAX_VALUE? -1: distance[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{

                {0,1,5},
                {1,2,5},
                {0,3,2},
                {3,1,2},
                {1,4,1},
                {4,2,1}
        };
        System.out.println(c.findCheapestPrice(5,flights,0, 2, 2));

    }

}
// 787. Cheapest Flights Within K Stops
