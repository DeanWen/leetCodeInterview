/*
如果当前遍历时，root比两个点都大，那么就往根的左边找 反之向右找，
如果node1 < root < node2 那么当前点就是LCA，
Corner case： 如果一个点为令一个点的祖先，那么这个点就是LCA
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }
}