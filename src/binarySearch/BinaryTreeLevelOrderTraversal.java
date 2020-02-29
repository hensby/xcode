package binarySearch;

import binaryTree.Node;
import binaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
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
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> levelOrder2(Node root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> current = new LinkedList<>(),nest = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            Node p = current.poll();
            l.add(p.data);
            if (p.left != null) {
                nest.add(p.left);
            }
            if (p.right != null) {
                nest.add(p.right);
            }
            if (current.isEmpty()) {
                res.add(l);
                l = new ArrayList<>();
                current = nest;
                nest = new LinkedList<>();
            }

        }
        return res;
    }



    public ArrayList<ArrayList<Integer>> levelOrderBottom(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> current = new LinkedList<>(), next = new LinkedList<>();
        current.add(root);
        ArrayList<Integer> l = new ArrayList<>();
        while (!current.isEmpty()) {
            Node p = current.poll();
            l.add(p.data);
            if (p.left != null) {
                next.add(p.left);
            }
            if (p.right != null) {
                next.add(p.right);
            }

            if (current.isEmpty()) {
                Queue<Node> tmp = current;
                current = next;
                next = tmp;
                result.add(0,l);
                l = new ArrayList<>();
            }
        }

        return result;
    }



    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        BinaryTree bt = new BinaryTree();
        ArrayList nodes = new ArrayList();
        nodes.add(5);
        nodes.add(2);
        nodes.add(12);
        nodes.add(3);
        nodes.add(9);
        nodes.add(21);
        nodes.add(25);
        nodes.add(19);
        nodes.add(-4);
        bt = bt.createBinaryTree(nodes);

        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(bt.root));
        System.out.println(binaryTreeLevelOrderTraversal.levelOrderBottom(bt.root));
        System.out.println(binaryTreeLevelOrderTraversal.levelOrder2(bt.root));
    }
}
