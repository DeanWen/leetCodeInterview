/*
循环解法：BFS#
有点类似二叉树层级遍历.
先验证root不为null，然后建立一个queue，把root加进队列。
定义变量layer为这一层的节点数，初始值为1； next为下一层节点数，初始值为0， 
rst为最大深度，初始值为1
进入循环，每次弹出队首作为当前节点。如果此节点左子树不为null，
加左子树到队尾，更新下一层节点数，同样的方法用于右子树。
当前节点数减1代表访问过了，如果这一层未访问的节点数是0，而且下一层有节点，
那么进入下一层，更新layer和next；如果没有下一层了，跳出循环，返回rst
*/
public int maxDepth(TreeNode root) {
    if(root == null)
        return 0;
    
    int depth = 0;
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int curNum = 1; //num of nodes left in current level
    int nextNum = 0; //num of nodes in next level
    while(!queue.isEmpty()){
        TreeNode n = queue.poll();
        curNum--;
        if(n.left!=null){
            queue.add(n.left);
            nextNum++;
        }
        if(n.right!=null){
            queue.add(n.right);
            nextNum++;
        }
        if(curNum == 0){
            curNum = nextNum;
            nextNum = 0;
            depth++;
        }
    }
    return depth;
}


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//DFS Recursion
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
            
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
