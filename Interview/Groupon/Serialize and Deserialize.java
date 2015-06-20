//Serialize and deserialize BST
//enCode and deCode BST

public class Solution {
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		helper(root, sb);
		return sb.toString();
	}

	public void helper(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("# ");
			return;
		}

		sb.append(node.data + " ");
		helper(node.left);
		helper(node.right);
	}

	private int i = 0;
	private TreeNode deserializeTree (String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}

		String ss = str.split("\\s+");
		return deserialize(ss);
	}

	private TreeNode deserialize(String[] ss) {
        if (i >= ss.length || ss[i].equals("#")) {
        	return null;
        }

        i++;
        TreeNode node = new TreeNode(Integer.valueOf(ss[i]));
        node.left = deserialize(ss);
        node.right = deserialize(ss);
        return node;
    }
} 