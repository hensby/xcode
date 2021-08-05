package bfs_dfs;

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

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        int[][] adjacency = new int[n][n];
        for(int[] flight: flights) {
            adjacency[flight[0]][flight[1]] = flight[2];
        }
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((l1, l2) -> l1[0] - l2[0]);
        pQueue.add(new int[]{0, 0, src});
        Map<Integer, Integer> best = new HashMap();

        while(!pQueue.isEmpty()) {
            int[] info = pQueue.poll();
            int cost = info[0], k = info[1], place = info[2];
            if (k > K+1 || cost > best.getOrDefault(k * 1000 + place, Integer.MAX_VALUE))
                continue;
            if (place == dst)
                return cost;

            for (int nei = 0; nei < n; ++nei) {
                if (adjacency[place][nei] > 0) {
                    int newcost = cost + adjacency[place][nei];
                    if (newcost < best.getOrDefault((k + 1) * 1000 + nei, Integer.MAX_VALUE)) {
                        pQueue.offer(new int[]{newcost, k + 1, nei});
                        best.put((k + 1) * 1000 + nei, newcost);
                    }
                }
            }
        }
        return -1;
    }


        private int[][] graph;
        private boolean[] visited;
        private int res = Integer.MAX_VALUE;

        public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
            K = Math.min(K, n - 2);

            this.graph = new int[n][n];
            for (int[] flight : flights) {
                graph[flight[0]][flight[1]] = flight[2];
            }

            for (int[] i: graph)
                System.out.println(Arrays.toString(i));

            this.visited = new boolean[n];
            // 开始深度优先遍历，注意：这里传 K + 1，这是因为 K 次经停，总共 K + 1 个站
            dfs(src, dst, K + 1, 0);

            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }


        /**
         * 从 src 出发，到 dst 为止，最多经过 k 站（这里 k 包括 src）
         *
         * @param src  起点站
         * @param dst  终点站
         * @param k    经过的站点数限制
         * @param cost 已经花费的价格
         */
        private void dfs(int src, int dst, int k, int cost) {
            if (src == dst) {
                res = cost;
                return;
            }

            if (k == 0) {
                return;
            }

            for (int i = 0; i < graph[src].length; i++) {
                if (graph[src][i] > 0) {
                    if (visited[i]) {
                        continue;
                    }

                    // 剪枝：跳过可能产生较高费用的路径，从而选出最少价格
                    if (cost + graph[src][i] > res) {
                        continue;
                    }

                    visited[i] = true;
                    dfs(i, dst, k - 1, cost + graph[src][i]);
                    visited[i] = false;
                }
            }
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
        int[][] flights1 = new int[][]{

                {0,1,100},
                {1,2,100},
                {0,2,500}
        };
//        System.out.println(c.findCheapestPrice(5,flights,0, 2, 2));
        System.out.println(c.findCheapestPrice1(5,flights,0, 2, 2));
        System.out.println(c.findCheapestPrice2(3,flights1,0, 2, 1));

    }

}
// 787. Cheapest Flights Within K Stops
