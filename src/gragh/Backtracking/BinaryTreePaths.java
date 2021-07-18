package gragh.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        List<String> tmpRes = new ArrayList<>();
        dfs(root, tmpRes);
        return res;
    }

    public void dfs(TreeNode node, List<String> tmpRes) {
        if (node == null) {
            return;
        }
        tmpRes.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            res.add(toPath(tmpRes));
        } else {
            dfs(node.left, tmpRes);
            dfs(node.right, tmpRes);
        }
        tmpRes.remove(tmpRes.size() - 1);
    }

    public String toPath(List<String> tmpRes) {
        if (tmpRes.size() == 1) return tmpRes.get(0);
        StringBuilder sb = new StringBuilder(tmpRes.get(0));
        for (int i = 1; i < tmpRes.size(); i++) {
            sb.append("->");
            sb.append(tmpRes.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryTreePaths by = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(by.binaryTreePaths(root));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
