package binaryTree;

import Amazon_oa.SubtreeWithMaximumAverage;

import java.util.Arrays;

public class MaximumAverageSubtree {

    //Definition for a binary tree node.
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

    double result = 0;

    public double maximumAverageSubtree(TreeNode root) {
        getSumAndCount(root);
        return result;
    }

    int[] getSumAndCount(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = getSumAndCount(root.left);
        int[] right = getSumAndCount(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        result = Math.max(result, 1.0 * sum / count);
        return new int[] {sum, count};
    }

    public static void main(String[] args) {
        MaximumAverageSubtree max = new MaximumAverageSubtree();
        TreeNode root = new TreeNode(5, new TreeNode(6), new TreeNode(1));
        System.out.println(max.maximumAverageSubtree(root));
    }
}
