package gragh;

import java.util.*;

public class EventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<Set<Integer>> g = new ArrayList<>();
        List<Set<Integer>> rg = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new HashSet<>());
            rg.add(new HashSet<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (graph[i].length == 0) {
                queue.offer(i);
                continue;
            }

            for (int j : graph[i]) {
                g.get(i).add(j);
                rg.get(j).add(i);
            }
        }

        List<Integer> result = new ArrayList<>(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);
            for (int reversed : rg.get(cur)) {
                Set<Integer> connections = g.get(reversed);
                connections.remove(cur);
                if (connections.isEmpty()) {
                    queue.offer(reversed);
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int n = graph.length;
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (noCycle(i, visiting, visited, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean noCycle(int node, Set<Integer> visiting, Set<Integer> visited, int[][] graph) {
        if (visited.contains(node)) {
            return true;
        }
        if (visiting.contains(node)) {
            return false;
        }

        visiting.add(node);
        for (int neighbor : graph[node]) {
            if (visited.contains(node)) {
                continue;
            }
            if (visiting.contains(neighbor) || !noCycle(neighbor, visiting, visited, graph)) {
                return false;
            }
        }

        visiting.remove(node);
        visited.add(node);
        return true;
    }

//    class UnionFind {
//        int[] id, size;
//        int count;
//
//        public UnionFind(int len) {
//            this.id = new int[len];
//            this.size = new int[len];
//            this.count = len;
//        }
//
//        public boolean find(int p, int q) {
//            return root(p) == root(q);
//        }
//
//        public void union(int p, int q) {
//            int pi = root(p), qi = root(q);
//            if (this.size[pi] < this.size[qi]) {
//                this.id[pi] = qi;
//                this.size[qi] += this.size[pi];
//            } else {
//                this.id[qi] = pi;
//                this.size[pi] += this.size[qi];
//            }
//            this.count--;
//        }
//
//        public int root(int i) {
//            while (i != id[i]) {
//                id[i] = id[id[i]]; // path compression
//                i = id[i];
//            }
//            return i;
//        }
//    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {}, {}};
        EventualSafeNodes eventualSafeNodes = new EventualSafeNodes();
        System.out.println(eventualSafeNodes.eventualSafeNodes2(graph));
    }
}
/**
 * Find Eventual Safe States
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 * <p>
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.
 * <p>
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 * <p>
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 * <p>
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 * <p>
 * Illustration of graph
 * <p>
 * Note:
 * <p>
 * graph will have length at most 10000.
 * The number of edges in the graph will not exceed 32000.
 * Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */