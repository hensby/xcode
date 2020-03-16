package binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagBinaryTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);
        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (!node_queue.isEmpty()) {
            TreeNode node = node_queue.pollFirst();
            if (node != null) {
                if (is_order_left)
                    level_list.addLast(node.val);
                else
                    level_list.addFirst(node.val);
                if (node.left != null)
                    node_queue.addLast(node.left);
                if (node.right != null)
                    node_queue.addLast(node.right);
            } else {
            // we finish the scan of one level
                res.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return res;
    }

}
//    103. Binary Tree Zigzag Level Order Traversal
//        Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]