package binaryTree;

public class IsSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 判断两树是否相等
     * @param l
     * @param r
     * @return
     */
    private boolean isEqual(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;//两树均空自然相等
        if(l == null || r == null) return false;//一空一非空，自然不等
        if(l.val == r.val)//递归判断
            return isEqual(l.left,r.left) && isEqual(l.right,r.right);
        return false;
    }
    /**
     * 判断 t 树是否是 s 树的子树
     * @param s
     * @param t
     * @return
     */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null) return false;
        if(s.val == t.val){
            return isEqual(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        // 根节点不同，那么就不同考虑s和t相等的情形了
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
