/*
Divid and Conquer to find if tree is complete binary tree (left == right)
if complete binary tree, the total node should be 2 ^ height - 1

if not
recursively count left and right to sum as total
*/
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
     
        int left = getLeftHeight(root) + 1;    
        int right = getRightHeight(root) + 1;
     
        if(left == right) {
            //since left has count root so minus 1
            //equals Math.pow(2, left - 1) - 1 but TLE
            return (2 << (left - 1)) - 1;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int getLeftHeight(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    
    private int getRightHeight(TreeNode root) {
        if (root == null) return 0;
        int height = 0;
        while (root.right != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}