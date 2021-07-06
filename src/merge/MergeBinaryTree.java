package merge;

import binaryTree.BinaryTree;
import binaryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class MergeBinaryTree {

//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }

    public static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Node merged = new Node(t1.data + t2.data);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        Node root1leftleft = new Node(5);
        Node root1left = new Node(3, root1leftleft, null);
        Node root1right = new Node(2);
        Node root1 = new Node(1, root1left, root1right);
//        bt.printBt(root1);

        Node root1leftright1 = new Node(4);
        Node root1rightright1 = new Node(7);
        Node root1left1 = new Node(1, null, root1leftright1);
        Node root1right1 = new Node(3, null, root1rightright1);
        Node root2 = new Node(2, root1left1, root1right1);
        Node res = mergeTrees(root1, root2);
        bt.printBt(res);
    }
}
//617. Merge Two Binary Trees
//        You are given two binary trees root1 and root2.
//
//        Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
//
//        Return the merged tree.
//
//        Note: The merging process must start from the root nodes of both trees.
//
//
//
//        Example 1:
//
//
//        Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//        Output: [3,4,5,5,4,null,7]
//        Example 2:
//
//        Input: root1 = [1], root2 = [1,2]
//        Output: [2,2]
