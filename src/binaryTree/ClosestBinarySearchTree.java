package binaryTree;

import java.util.ArrayList;

public class ClosestBinarySearchTree {

    public int closestValue(Node root, double target){
        int res = root.data;
        while(root!= null) {
            double diff = Math.abs(target - root.data);
            if (diff < 1e-10){
                return root.data;
            }

            if (diff < Math.abs(target - res)){
                res = root.data;
            }
            root = root.data > target ? root.left : root.right;

        }
        return res;
    }

    public static void main(String[] args) {
        ClosestBinarySearchTree closestBinarySearchTree = new ClosestBinarySearchTree();
        BinaryTree bt = new BinaryTree();
        ArrayList nodes = new ArrayList();
        nodes.add(5);nodes.add(2);nodes.add(12);nodes.add(3);
        nodes.add(9);nodes.add(21);nodes.add(25);nodes.add(19);nodes.add(-4);
        bt = bt.createBinaryTree(nodes);
        bt.printBt(bt.root);
        int res = closestBinarySearchTree.closestValue(bt.root, 8.0);
        System.out.println(res);
    }
}
