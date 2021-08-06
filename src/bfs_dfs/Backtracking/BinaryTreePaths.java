package bfs_dfs.Backtracking;

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

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//         时间复杂度：O(N^2)其中 NN 表示节点数目。在深度优先搜索中每个节点会被访问一次且只会被访问一次，每一次会对 path 变量进行拷贝构造，时间代价为 O(N)O(N)，故时间复杂度为 O(N^2)
//
//         空间复杂度：O(N^2)其中 NN 表示节点数目。除答案数组外我们需要考虑递归调用的栈空间。在最坏情况下，当二叉树中每个节点只有一个孩子节点时，即整棵二叉树呈一个链状，此时递归的层数为 NN，此时每一层的 path 变量的空间代价的总和为 O(N^2)
//)        空间复杂度为 O(N^2)O(N)。最好情况下，当二叉树为平衡二叉树时，它的高度为 \log NlogN，此时空间复杂度为 O((\log{N})^2)
//257. Binary Tree Paths
//        Given the root of a binary tree, return all root-to-leaf paths in any order.
//
//        A leaf is a node with no children.
//
//
//
//        Example 1:
//
//
//        Input: root = [1,2,3,null,5]
//        Output: ["1->2->5","1->3"]
//        Example 2:
//
//        Input: root = [1]
//        Output: ["1"]
//
//
//        Constraints:
//
//        The number of nodes in the tree is in the range [1, 100].
//        -100 <= Node.val <= 100