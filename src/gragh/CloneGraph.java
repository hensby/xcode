package gragh;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // bfs
        // Key is the node in original graph and value is the corresponding
        // cloned node
        Map<Node, Node> map = new HashMap<>();
        // Queue to iterate through all nodes in original graph
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node graphCopy = new Node(node.val);
        map.put(node, graphCopy);

        while (!q.isEmpty()) {
            Node n = q.poll();
            Node clone = map.get(n);
            for (Node neighbor : n.neighbors) {
                Node copy = map.computeIfAbsent(neighbor, k -> {
                    q.add(k);
                    return new Node(k.val);
                });
                clone.neighbors.add(copy);
            }
        }

        return graphCopy;
    }

    // DFS
    public Node cloneGraph2(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, Map<Node, Node> clones) {
        if (node == null) {
            return null;
        }

        Node clone = clones.get(node);
        if (clone != null) {
            return clone;
        }
        clone = new Node(node.val);
        clones.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor, clones));
        }
        return clone;
    }

    private void dfs(Node cur, Set<Node> visited) {
        if (cur == null || visited.contains(cur)) {
            return;
        }

        visited.add(cur);

        for (Node neighbor : cur.neighbors) {
            dfs(neighbor, visited);
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    public static void main(String[] args) {

    }
}
