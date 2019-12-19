package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public Node root;

    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.data) {
            current.left = addNode(current.left, value);
        } else if (value > current.data) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void addNode(int value) {
        root = addNode(root, value);
    }

    public BinaryTree createBinaryTree(List<Integer> nodes) {
        BinaryTree bt = new BinaryTree();
        int i = 0;
        while( i < nodes.size()) {
            bt.addNode(nodes.get(i));
            i++;
        }
        return bt;
    }


    public List<List<Integer>> printBt(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                Node cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                subList.add(cur.data);
            }
            result.add(subList);
            System.out.println(subList);
        }
        return result;
    }
}



