/*
思路：如果对于当前层的全部节点，已经设置好他们的next指针。
那么对于下一层的节点，也可以按照同样原理来设置他们的next指针。
时间O（n） 空间 O（1）
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr;
        while (root.left != null) {
            curr = root;
            
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            
            root = root.left;
        }
    }
}

//recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root;
        if (current == null) {
            return;
        }
        if (current.left != null) {
            current.left.next = current.right;
        }
        if (current.right != null) {
            if (current.next == null) {
                current.right.next = null;
            }else {
                current.right.next = current.next.left;
            }
        }
        
        connect(current.left);
        connect(current.right);
    }
}