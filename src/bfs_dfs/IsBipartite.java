package bfs_dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsBipartite {
    /**
     * Is Graph Bipartite?
     * Given an undirected graph, return true if and only if it is bipartite.
     * <p>
     * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
     * <p>
     * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
     * <p>
     * Example 1:
     * Input: [[1,3], [0,2], [1,3], [0,2]]
     * Output: true
     * Explanation:
     * The graph looks like this:
     * 0----1
     * |    |
     * |    |
     * 3----2
     * We can divide the vertices into two groups: {0, 2} and {1, 3}.
     * Example 2:
     * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
     * Output: false
     * Explanation:
     * The graph looks like this:
     * 0----1
     * | \  |
     * |  \ |
     * 3----2
     * We cannot find a way to divide the set of nodes into two independent subsets.
     * <p>
     * <p>
     * Note:
     * <p>
     * graph will have length in range [1, 100].
     * graph[i] will contain integers in range [0, graph.length - 1].
     * graph[i] will not contain i or duplicate values.
     * The graph is undirected: if any element j is in graph[i], then i will be in graph[j]
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; //nums of nodes
        // use two sets to store nodes as bipartite
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        List<Set<Integer>> twoSets = new ArrayList<>();
        twoSets.add(a);
        twoSets.add(b);

        for (int i = 0; i < n; i++) {
            final int node = i;
            // This graph might be a disconnected graph. So check each unvisited node.
            if (!twoSets.stream().anyMatch(k -> k.contains(node)) && !isValid(graph, twoSets, 0, i)) {
                // !a.contains(i) && !b.contains(i) means not visited
                return false;
            }

        }
        return true;
    }

    private boolean isValid(int[][] graph, List<Set<Integer>> twoSets, int setIndex, final int node) {
        // find valid or not. for node, if each neighbor of the node is in the other set.
        // setIndex is either 0 or 1
        Set<Integer> curSet = twoSets.get(setIndex);
        if (twoSets.stream().anyMatch(s -> s.contains(node))) {
            return curSet.contains(node);
        }
        curSet.add(node);
        for (int neighbor : graph[node]) {
            if (!isValid(graph, twoSets, 1 - setIndex, neighbor)) {
                return false;
            }
        }
        return true;


    }

    class GraphNode {
        List<GraphNode> children;

        public List<GraphNode> getChildren() {
            return this.children;
        }
    }

    public static void main(String[] args) {
        IsBipartite isBipartite = new IsBipartite();

    }
}
