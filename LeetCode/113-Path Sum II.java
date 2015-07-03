public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<Integer> list = new LinkedList<Integer>();
        list.add(root.val);
        dfs(res, root, sum - root.val, list);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int sum, List<Integer> list) {
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<Integer>(list));
            return;
        }
        
        if (root.left != null) {
            list.add(root.left.val);
            dfs(res, root.left, sum - root.left.val, list);
            list.remove(list.size() - 1);
        }
        
        if (root.right != null) {
            list.add(root.right.val);
            dfs(res, root.right, sum - root.right.val, list);
            list.remove(list.size() - 1);
        }
    }
}