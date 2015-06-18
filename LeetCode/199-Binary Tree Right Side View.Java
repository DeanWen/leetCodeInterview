public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        traverse(root, 0, map);
        return new ArrayList<>(map.values());
    }
    
    private void traverse(TreeNode node, int level, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.put(level, node.val);
        traverse(node.left, level + 1, map);
        traverse(node.right, level + 1, map);
    }
}