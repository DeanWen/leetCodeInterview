/*
* Inorder Iterative
* Time O(k)
* space O(k)
*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode parent = stack.pop();
                if (--k == 0) {
                    return parent.val;
                }
                curr = parent.right;
            }
        } 

        return 0;
    }
}

/*
* Inorder Recursion
* Time O(n)
* space O(n)
*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> inorder = new LinkedList<>();
        helper(root, inorder);
        return inorder.get(k - 1);
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
}


