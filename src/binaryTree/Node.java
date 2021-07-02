package binaryTree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }
    public Node() {}

    public Node(int val, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.data = val;
    }

}
