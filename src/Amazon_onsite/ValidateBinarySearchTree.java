package Amazon_onsite;

public class ValidateBinarySearchTree {

    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);//定义一个node的值得区间范围
    }

    public boolean isValidBST(TreeNode node, long minVal, long maxVal) {
        if (node == null) {//空树也是一个搜索树
            return true;
        }
        if (node.val <= minVal || node.val >= maxVal) {//如果不在这个区间则返回false
            return false;
        }
        //递归遍历左右子树，左子树时修改上界为当前节点值，右子树时修改下界为当前节点值
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }
}
