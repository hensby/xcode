package binaryTree;

// 1120
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

    public int[] getSumAndCount(TreeNode root) {
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
//题目：
//
//        Given the root of a binary tree, find the maximum average value of any subtree of that tree.
//
//        (A subtree of a tree is any node of that tree plus all its descendants.
//        The average value of a tree is the sum of its values, divided by the number of nodes.)

//        Example 1:
//          5
//         / \
//        6   1
//
//        Input: [5,6,1]
//        Output: 6.00000
//        Explanation:
//        For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
//        For the node with value = 6 we have an average of 6 / 1 = 6.
//        For the node with value = 1 we have an average of 1 / 1 = 1.
//        So the answer is 6 which is the maximum.
